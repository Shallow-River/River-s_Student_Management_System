package com.example.back.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Change {
    private Long id;

    private Long studentId;

    private Long changeId;

    private Date recTime;

    private String description;
}
