package com.app.util;

import com.app.entity.UserDetailsEntity;
import com.app.model.User;
import com.app.model.UserDetails;

public class UserDetailsResponseConverter {

    public static UserDetails convert(UserDetailsEntity userDetails){
        UserDetails user = new UserDetails();
        user.setId(userDetails.getId());
        user.setName(userDetails.getName());
        user.setDob(userDetails.getDob());
        user.setGender(userDetails.getGender());
        user.setPhone(userDetails.getPhone());
        user.setUserProfileImageUrl(userDetails.getUserProfileImageUrl());
        user.setFacebookLink(userDetails.getFacebookLink());
        user.setTwitterLink(userDetails.getTwitterLink());

        user.setInstagramLink(userDetails.getInstagramLink());
        return user;
    }
}
