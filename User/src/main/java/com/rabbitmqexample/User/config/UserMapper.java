package com.rabbitmqexample.User.config;

import com.rabbitmqexample.User.dto.UserDTO;
import com.rabbitmqexample.User.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "userBalance", target = "userBalance")
    @Mapping(source = "createDate", target = "createDate")
    @Mapping(source = "upDatetime", target = "upDatetime")
    UserDTO userToUserDTO(User user);
}

