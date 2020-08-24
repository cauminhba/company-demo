package com.example.study.repository;

import com.example.study.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company,Integer>, CompanyRepositoryCustom {
    @Modifying
    @Query(value = "update Company c set c.is_deleted = 0 where c.company_id = :id", nativeQuery = true)
    void softDelete(@Param("id") Integer companyId);

    @Query(value = "SELECT * FROM Company c where c.is_active=true " +
            "and c.is_deleted=false ", nativeQuery = true)
    List<Company> findAll();

    Company findByCompanyId(Integer companyId);

}
