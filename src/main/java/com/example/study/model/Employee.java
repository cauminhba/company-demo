package com.example.study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    @NotNull
    private int employeeId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;

    @Column(name="first_name")
    private String firstName;

    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_password")
    private String password;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @Column(name="role_name")
    private String roleName;

}
