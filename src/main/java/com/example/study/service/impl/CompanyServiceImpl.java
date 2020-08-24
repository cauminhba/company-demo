package com.example.study.service.impl;

import com.example.study.model.Company;
import com.example.study.model.dto.UpdateCompanyDTO;
import com.example.study.repository.CompanyRepository;
import com.example.study.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        companyRepository.create(company);
        return company;
    }

    @Override
    public Company updateCompany(Integer companyId, UpdateCompanyDTO companyToUpdate ) {
        Company company = companyRepository.findByCompanyId(companyId);
        company.setCompanyName(companyToUpdate.getCompanyName());
        company.setCompanyAddress(companyToUpdate.getCompanyAddress());
        company.setCompanyType(companyToUpdate.getCompanyType());
        companyRepository.update(company);
        return company;
    }

    @Override
    public Company deleteCompany(Integer companyId) {
        companyRepository.softDelete(companyId);
        Company deleted = companyRepository.findByCompanyId(companyId);
        return deleted;
    }
}
