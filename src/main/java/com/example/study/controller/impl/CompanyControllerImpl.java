package com.example.study.controller.impl;

import com.example.study.controller.CompanyController;
import com.example.study.model.Company;
import com.example.study.model.dto.UpdateCompanyDTO;
import com.example.study.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompanyControllerImpl implements CompanyController {
    @Autowired
    private CompanyService companyService;

    @Override
    public ResponseEntity<?> createCompany(Company company) {
        Company created = companyService.createCompany(company);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<?> updateCompany(UpdateCompanyDTO updateCompanyDTO, Integer companyId) {
        Company updated = companyService.updateCompany(companyId, updateCompanyDTO);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<?> deleteCompany(Integer companyId) {
        Company deleted = companyService.deleteCompany(companyId);
        return ResponseEntity.ok(deleted);
    }

    @Override
    public ResponseEntity<?> findAllCompany() {
        List<Company> companies = companyService.getAllCompany();
        return ResponseEntity.ok(companies);
    }
}
