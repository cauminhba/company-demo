package com.example.study.repository;

import com.example.study.model.Employee;

public interface EmployeeRepositoryCustom {
    Employee create(Employee employee);

    void update(Employee employee);
}
