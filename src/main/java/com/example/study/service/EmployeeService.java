package com.example.study.service;

import com.example.study.model.Employee;
import com.example.study.model.UserPrincipal;
import com.example.study.model.dto.UpdateEmployeeDTO;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();

    List<Employee> findByCompany(Integer companyId);

    Employee update(Integer employeeId, UpdateEmployeeDTO employeeToUpdate);

    Employee delete(Integer employeeId);

    Employee create(Employee employee);

    UserPrincipal findByUserName(String userName);

}
