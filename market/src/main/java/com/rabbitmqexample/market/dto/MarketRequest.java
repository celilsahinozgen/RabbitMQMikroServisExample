package com.rabbitmqexample.market.dto;


import lombok.Data;


public class MarketRequest {

    private String urunId;
    private Integer userBalance;
    private String model;

    private Integer quantityFound;


    public MarketRequest(String urunId, Integer userBalance, String model, Integer quantityFound) {
        this.urunId = urunId;
        this.userBalance = userBalance;
        this.model = model;
        this.quantityFound = quantityFound;
    }


    public String getUrunId() {
        return urunId;
    }

    public void setUrunId(String urunId) {
        this.urunId = urunId;
    }

    public Integer getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Integer userBalance) {
        this.userBalance = userBalance;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getQuantityFound() {
        return quantityFound;
    }

    public void setQuantityFound(Integer quantityFound) {
        this.quantityFound = quantityFound;
    }
}

/*
      urunId;
      userBalance;
      model;

      quantityFound;
 */
