package com.example.study.controller;


import com.example.study.model.Company;
import com.example.study.model.dto.UpdateCompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public interface CompanyController {
    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('USER_CREATE')")
    ResponseEntity<?> createCompany(@RequestBody Company company);

    @RequestMapping(value = "/{companyId}", method = RequestMethod.PUT)
    @PreAuthorize("hasAnyAuthority('USER_UPDATE')")
    ResponseEntity<?> updateCompany(@RequestBody UpdateCompanyDTO updateCompanyDTO,
                                    @PathVariable(name = "companyId") Integer companyId);

    @RequestMapping(value = "/{companyId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('USER_DELETE')")
    ResponseEntity<?> deleteCompany(@PathVariable Integer companyId);

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('USER_READ')")
    ResponseEntity<?> findAllCompany();
}
