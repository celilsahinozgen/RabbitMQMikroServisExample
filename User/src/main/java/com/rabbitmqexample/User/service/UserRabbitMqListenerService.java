package com.rabbitmqexample.User.service;



import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.rabbitmqexample.User.dto.ResponseMessage;

@Service
public class UserRabbitMqListenerService {

    @RabbitListener(queues = "secondStepQueue")
    public void receiveResponse(ResponseMessage responseMessage) {
        if (responseMessage.isSuccess()) {
            handleSuccessResponse(responseMessage);
        } else {
            handleErrorResponse(responseMessage);
        }
    }

    private void handleSuccessResponse(ResponseMessage responseMessage) {
        // Baraşlıgı ise istedigimiz şekilde döneriz keydet şunu yap bunu yap gibi
        System.out.println("Success: " + responseMessage.getMessage() + " for Özel Numara: " + responseMessage.getOzelNumara());

    }

    private void handleErrorResponse(ResponseMessage responseMessage) {

        System.out.println("Error: " + responseMessage.getMessage() + " for Özel Numara: " + responseMessage.getOzelNumara());
       //Log atılabilir yada yata yönetimi daha iyi tasarlana bilir
    }
}


