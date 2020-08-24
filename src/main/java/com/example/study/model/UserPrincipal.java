package com.example.study.model;

import lombok.Data;

import java.util.List;

@Data
public class UserPrincipal {


    private int userId;

    private String userName;

    private String userPassword;

    private int companyId;

    private List<String> authorities;
}
