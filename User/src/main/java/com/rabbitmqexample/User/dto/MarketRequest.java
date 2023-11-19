package com.rabbitmqexample.User.dto;

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

    public Integer getOzelNumara() {
        return userBalance;
    }

    public void setOzelNumara(Integer ozelNumara) {
        this.userBalance = ozelNumara;
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
