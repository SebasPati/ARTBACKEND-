package com.challengerFinal.arte.dtos;

public class ClientRegister {
    private Long userId;
    private String username;
    private String lastName;
    private String email;
    private String password;
    private String nickname;
    private Integer telefone;

    public ClientRegister() {
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
}
