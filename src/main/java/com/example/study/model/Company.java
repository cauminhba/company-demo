package com.example.study.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    @NotNull
    @JsonIgnore
    private int companyId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="company_address")
    private String companyAddress;

    @Column(name="company_type")
    private String companyType;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="is_deleted")
    private Boolean isDeleted;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Employee> employees;

}
