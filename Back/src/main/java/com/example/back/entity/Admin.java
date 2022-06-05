package com.example.back.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String password;

    private String authority;
}
