package com.rabbitmqexample.market.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Entity
@Table(name = "MARKETDATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Market {


    public static final String ZAMANPATTERIN = "yyyy-MM-dd HH:mm:ss";
    public static final String YILPATTERIN = "yyyy-MM-dd";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(name = "URUNID")
    private String urunId;

    @Column(name = "MARKA")
    private String ozelNumara;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "BANK")
    private String bank;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "QUANTITYFOUND")
    private Integer quantityFound;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
