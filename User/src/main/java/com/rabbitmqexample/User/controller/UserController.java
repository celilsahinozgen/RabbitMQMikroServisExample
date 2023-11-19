package com.rabbitmqexample.User.controller;


import com.rabbitmqexample.User.dto.MarketRequest;
import com.rabbitmqexample.User.dto.ResponseMessage;
import com.rabbitmqexample.User.dto.UserDTO;
import com.rabbitmqexample.User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/market-request")
    public ResponseEntity<String> sendMarketRequest(@RequestBody MarketRequest marketRequest) {
        try {
            userService.sendMarketRequest(marketRequest);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
          // LOgg atacam
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("İşlem sırasında bir hata oluştu.");
        }
    }


    @GetMapping("/market-response")
    public ResponseEntity<ResponseMessage> getLatestMarketResponse() {
        ResponseMessage latestResponse = userService.getLatestResponse();
        if (latestResponse == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(latestResponse);
    }





    @GetMapping
    public ResponseEntity<List<UserDTO>> ResponseList(){
        List<UserDTO> userDTOSList= userService.findAllUser();
        return ResponseEntity.ok(userDTOSList);
     }



}
