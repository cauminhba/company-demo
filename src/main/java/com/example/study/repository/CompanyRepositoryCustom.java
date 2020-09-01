package com.example.study.repository;

import com.example.study.model.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepositoryCustom {
    void create(Company company);

    void update(Company company);


}
