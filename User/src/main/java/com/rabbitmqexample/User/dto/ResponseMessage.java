package com.rabbitmqexample.User.dto;

public class ResponseMessage {

    private boolean success;
    private String message;
    private String ozelNumara;


    public ResponseMessage(boolean success, String message, String ozelNumara) {
        this.success = success;
        this.message = message;
        this.ozelNumara = ozelNumara;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOzelNumara() {
        return ozelNumara;
    }

    public void setOzelNumara(String ozelNumara) {
        this.ozelNumara = ozelNumara;
    }
}
