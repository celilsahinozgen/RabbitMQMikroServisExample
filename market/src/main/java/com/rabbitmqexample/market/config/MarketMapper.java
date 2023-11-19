package com.rabbitmqexample.market.config;

import com.rabbitmqexample.market.dto.MarketDTO;
import com.rabbitmqexample.market.model.Market;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MarketMapper {

    @Mapping(source = "urunId", target = "urunId")
    @Mapping(source = "ozelNumara", target = "ozelNumara")
    @Mapping(source = "model",target = "model")
    @Mapping(source = "bank", target = "bank")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantityFound",target = "quantityFound")
    MarketDTO marketToMarketDTO(Market market);



}
