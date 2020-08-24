package com.example.study.service;

import com.example.study.model.Company;
import com.example.study.model.dto.UpdateCompanyDTO;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();

    Company createCompany(Company company);

    Company updateCompany(Integer companyId, UpdateCompanyDTO companyToUpdate);

    Company deleteCompany(Integer companyId);
}
