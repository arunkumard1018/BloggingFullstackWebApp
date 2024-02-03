package com.app.controllers;

import java.util.Optional;

import com.app.entity.UserDetailsEntity;
import com.app.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.UserDetailsSevice;

@RestController
public class UsersResourceController {

    private UserDetailsSevice userDetailsSevice;
    public UsersResourceController(UserDetailsSevice userDetailsSevice) {
        this.userDetailsSevice = userDetailsSevice;
    }

    @GetMapping("/user/{username}/basicdetails")
    public BasicUserInfo basicUserInfo(@PathVariable String username){
        Optional<UserDetailsEntity> userDetails = userDetailsSevice.findByEmail(username);
        if(userDetails.isEmpty()){
            throw new UserNotFoundException("user name : "+ username);
        }
        UserDetailsEntity user = userDetails.get();
        return new BasicUserInfo(user.getId(),user.getUserProfileImageUrl());
    }
}

record BasicUserInfo(Long userId,String profileImgUrl){};
