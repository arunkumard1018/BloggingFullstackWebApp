package com.app.controllers;

import java.util.Optional;

import com.app.entity.UserDetailsEntity;
import com.app.exceptions.UserNotFoundException;
import com.app.model.UserDetails;
import com.app.service.AuthenticationService;
import com.app.util.UserDetailsResponseConverter;
import com.app.util.UserIDAndProfile;
import com.app.util.UserId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.UserDetailsSevice;

@RestController
public class UsersResourceController {

    private AuthenticationService authenticationService;
    private UserDetailsSevice userDetailsSevice;

    public UsersResourceController(AuthenticationService authenticationService, UserDetailsSevice userDetailsSevice) {
        this.authenticationService = authenticationService;
        this.userDetailsSevice = userDetailsSevice;
    }

    @GetMapping("/users/{username}/id")
    public UserId retriveIdForUserName(@PathVariable String username){
        Long id = authenticationService.getUserId(username);
        if(id == null){
            throw new UserNotFoundException("user name : "+ username);
        }
        return new UserId(id);
    }

    @GetMapping("/user/{username}/id/profile")
    public UserIDAndProfile retriveProfileLinkAndIdForUserName(@PathVariable String username){
        Long id = authenticationService.getUserId(username);
        if(id == null) throw new UserNotFoundException("user name : "+ username);

        Optional<UserDetailsEntity> userDetails = userDetailsSevice.findById(id);
        if(userDetails.isEmpty()){
            throw new UserNotFoundException("user name : "+ username);
        }
        return new UserIDAndProfile(id,userDetails.get().getUserProfileImageUrl());
    }
    
    @GetMapping("/users/{id}/userinfo")
    public UserDetails userInfo(@PathVariable Long id){
        Optional<UserDetailsEntity> userDetails = userDetailsSevice.findById(id);
        if(userDetails.isEmpty()){
            throw new UserNotFoundException("user id : "+ id);
        }
        return UserDetailsResponseConverter.convert(userDetails.get());
    }
}

