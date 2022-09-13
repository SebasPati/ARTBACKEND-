package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.UserGlobal;

public class UserDTO {
    private long userId;
    private String userName;
    private String userLastName;
    private String userEmail;


    public UserDTO() {
    }

    public UserDTO(UserGlobal user) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.userLastName = user.getLastName();
        this.userEmail = user.getEmail();
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

}
