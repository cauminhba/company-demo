package com.example.study.model.dto;

import lombok.Data;

@Data
public class UpdateEmployeeDTO {
    private int employeeId;
    private String firstName;
    private String surname;
    private String email;
}
