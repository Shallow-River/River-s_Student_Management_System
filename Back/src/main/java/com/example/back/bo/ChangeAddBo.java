package com.example.back.bo;

import lombok.Data;

@Data
public class ChangeAddBo {
    private static final long serialVersionUID = 1L;

    private Long studentId;

    private Long changeId;

    private String description;
}
