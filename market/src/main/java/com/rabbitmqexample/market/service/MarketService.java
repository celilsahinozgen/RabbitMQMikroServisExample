package com.rabbitmqexample.market.service;

import com.rabbitmqexample.market.config.MarketMapper;
import com.rabbitmqexample.market.dto.MarketDTO;
import com.rabbitmqexample.market.dto.MarketRequest;
import com.rabbitmqexample.market.dto.ResponseMessage;
import com.rabbitmqexample.market.model.Market;

import com.rabbitmqexample.market.repository.MarketRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketService {

    private static final Logger logger = LoggerFactory.getLogger(MarketService.class);

    private final MarketRepository marketRepository;
    private final MarketMapper marketMapper;


    private  MarketRequest marketRequest;
    private final RabbitTemplate rabbitTemplate;





    public MarketService(MarketRepository marketRepository, MarketMapper marketMapper, RabbitTemplate rabbitTemplate) {
        this.marketRepository = marketRepository;
        this.marketMapper = marketMapper;


        this.rabbitTemplate = rabbitTemplate;
    }


    @RabbitListener(queues = "firstStepQueue")
    @Transactional
    public void receiveMarketRequest(MarketRequest marketRequest) {
        try {
            Market marketItem = fetchMarketItem(marketRequest);

            if (isTransactionValid(marketItem, marketRequest)) {
                processMarketTransaction(marketItem, marketRequest);
                sendSuccessResponse(marketRequest);
                logger.debug("Transaction successful for request: {}", marketRequest);
            } else {
                sendErrorResponse(marketRequest, "Insufficient balance or stock");
                logger.warn("Transaction failed: Insufficient balance or stock for request: {}", marketRequest);
            }

        } catch (Exception e) {
            handleTransactionError(marketRequest, e);
        }
    }

    private Market fetchMarketItem(MarketRequest marketRequest) {
        return marketRepository.findByUrunId(marketRequest.getUrunId())
                .orElseThrow(() -> new RuntimeException("Item not found: " + marketRequest.getUrunId()));
    }

    private boolean isTransactionValid(Market marketItem, MarketRequest marketRequest) {
        return marketItem.getPrice() <= marketRequest.getUserBalance() &&
                marketItem.getQuantityFound() >= marketRequest.getQuantityFound();
    }

    private void processMarketTransaction(Market marketItem, MarketRequest marketRequest) {
        marketItem.setQuantityFound(marketItem.getQuantityFound() - marketRequest.getQuantityFound());
        marketRepository.save(marketItem);
    }

    private void sendSuccessResponse(MarketRequest marketRequest) {
        ResponseMessage response = new ResponseMessage(true, "Transaction successful", marketRequest.getUrunId());
        rabbitTemplate.convertAndSend("exchangeCelil", "secondStepQueue", response);
    }

    private void sendErrorResponse(MarketRequest marketRequest, String errorMessage) {
        ResponseMessage response = new ResponseMessage(false, errorMessage, marketRequest.getModel());
        rabbitTemplate.convertAndSend("exchangeCelil", "secondStepQueue", response);
    }

    private void handleTransactionError(MarketRequest marketRequest, Exception e) {
        sendErrorResponse(marketRequest, e.getMessage());
        logger.error("Error processing market request: {}", marketRequest, e);
    }











    public List<MarketDTO> findAllMarket() {
        List<Market> marketlistesi = marketRepository.findAll();
        List<MarketDTO> marketDTOList = marketlistesi.stream().map(marketMapper::marketToMarketDTO).collect(Collectors.toList());
        return marketDTOList;
    }





}
