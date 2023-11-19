package com.rabbitmqexample.market.dto;

public class MarketDTO {

    private String urunId;
    private String ozelNumara;
    private String model;
    private String bank;
    private Integer price;
    private Integer quantityFound;


    public String getUrunId() {
        return urunId;
    }

    public void setUrunId(String urunId) {
        this.urunId = urunId;
    }

    public String getOzelNumara() {
        return ozelNumara;
    }

    public void setOzelNumara(String ozelNumara) {
        this.ozelNumara = ozelNumara;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantityFound() {
        return quantityFound;
    }

    public void setQuantityFound(Integer quantityFound) {
        this.quantityFound = quantityFound;
    }
}
