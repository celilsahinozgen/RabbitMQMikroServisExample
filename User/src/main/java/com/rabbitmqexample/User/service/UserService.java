package com.rabbitmqexample.User.service;

import com.rabbitmqexample.User.config.UserMapper;
import com.rabbitmqexample.User.dto.MarketRequest;
import com.rabbitmqexample.User.dto.ResponseMessage;
import com.rabbitmqexample.User.dto.UserDTO;
import com.rabbitmqexample.User.model.User;
import com.rabbitmqexample.User.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;

   private final UserMapper userMapper;

    private final RabbitTemplate rabbitTemplate;
    private ResponseMessage latestResponse;



    public UserService(UserRepository userRepository, UserMapper userMapper, RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.rabbitTemplate = rabbitTemplate;
    }




// Body olarak gönder
    public void sendMarketRequest(MarketRequest marketRequestDto) {
        rabbitTemplate.convertAndSend("exchangeCelil", "firstStepQueue", marketRequestDto);
    }

    @RabbitListener(queues = "secondStepQueue")
    public void receiveResponse(ResponseMessage responseMessage) {
        this.latestResponse = responseMessage;
    }

    public ResponseMessage getLatestResponse() {
        return latestResponse;
    }


    public List<UserDTO> findAllUser() {

        List<User> listuser=  userRepository.findAll();
        List<UserDTO> userDTOList= listuser.stream().map(
                userMapper::userToUserDTO).collect(Collectors.toList());
        return userDTOList;
    }



}
