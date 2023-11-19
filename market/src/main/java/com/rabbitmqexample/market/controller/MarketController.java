package com.rabbitmqexample.market.controller;


import com.rabbitmqexample.market.dto.MarketDTO;
import com.rabbitmqexample.market.service.MarketService;
import jakarta.persistence.Column;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }


    @GetMapping()
    public ResponseEntity<List<MarketDTO>> findAllMarket() {

        List<MarketDTO> marketDTOList = marketService.findAllMarket();
        return ResponseEntity.ok(marketDTOList);
    }







}
