package com.example.study.controller.impl;

import com.example.study.exception.HttpBadRequestException;
import com.example.study.exception.HttpConflictException;
import com.example.study.model.Employee;
import com.example.study.model.dto.UpdateEmployeeDTO;
import com.example.study.service.EmployeeService;
import com.example.study.controller.EmployeeController;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.ValidationException;
import java.util.List;

@Controller
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<?> createEmployee(Employee employee) {
        try {
            Employee created = employeeService.create(employee);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException | ValidationException e) {
            throw new HttpBadRequestException(e.getMessage());
        } catch (HibernateException e) {
            throw new HttpConflictException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateEmployee(UpdateEmployeeDTO updateEmployeeDTO, Integer employeeId) {
            Employee employee = employeeService.update(employeeId,updateEmployeeDTO);
            return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<?> deleteEmployee(Integer employeeId) {
        Employee employee =  employeeService.delete(employeeId);
        return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<?> findEmployeeByCompany(Integer companyId) {
        List<Employee> employees = employeeService.findByCompany(companyId);
        return ResponseEntity.ok(employees);
    }

}
