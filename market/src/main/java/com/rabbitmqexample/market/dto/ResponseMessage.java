package com.rabbitmqexample.market.dto;

public class ResponseMessage {

    private boolean success;
    private String message;
    private String ozelNumara; // İşlemi başlatan özel numara veya başka bir tanımlayıcı

    // Constructor, Getters ve Setters

    public ResponseMessage(boolean success, String message, String ozelNumara) {
        this.success = success;
        this.message = message;
        this.ozelNumara = ozelNumara;
    }
}
