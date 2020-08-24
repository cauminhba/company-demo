package com.example.study.repository;

import com.example.study.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>, EmployeeRepositoryCustom {
    @Modifying
    @Query(value = "update Employee e set e.is_deleted = 1 where e.employee_id = :id", nativeQuery = true)
    void softDelete(@Param("id") Integer companyId);
    @Modifying
    @Query(value = "SELECT * FROM Employee e where e.company_id = :id " +
            "and e.is_active=true and e.is_deleted=false",nativeQuery = true)
    List<Employee> findAllByCompanyId(@Param("id")  Integer companyId);

    Employee findByEmployeeId(Integer employeeId);

    Employee findByUserName(String userName);
}
