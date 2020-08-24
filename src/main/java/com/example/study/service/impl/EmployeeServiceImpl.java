package com.example.study.service.impl;

import com.example.study.model.*;
import com.example.study.model.dto.UpdateEmployeeDTO;
import com.example.study.repository.EmployeeRepository;
import com.example.study.repository.RolePermissionRepository;
import com.example.study.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByCompany(Integer companyId) {
        return employeeRepository.findAllByCompanyId(companyId);
    }

    @Override
    public Employee update(Integer employeeId, UpdateEmployeeDTO employeeToUpdate) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        employee.setFirstName(employeeToUpdate.getFirstName());
        employee.setSurname(employeeToUpdate.getSurname());
        employee.setEmail(employeeToUpdate.getEmail());
        employeeRepository.update(employee);
        return employee;
    }

    @Override
    public Employee delete(Integer employeeId) {
        employeeRepository.softDelete(employeeId);
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        return employee;
    }

    @Override
    public Employee create(Employee employee) {
        employee.setIsActive(Boolean.TRUE);
        employee.setIsDeleted(Boolean.FALSE);
        employee.setRoleName("USER");
        Employee created = employeeRepository.create(employee);
        return created;
    }

    @Override
    public UserPrincipal findByUserName(String userName) {
        Employee employee = employeeRepository.findByUserName(userName);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != employee) {
            Set<String> authorities = new HashSet<>();
            String roleName = employee.getRoleName();
            if (null != employee.getRoleName()) {
                authorities.add(roleName);
                List<RolePermission> rolePermissionList = rolePermissionRepository.findByRoleName(roleName);
                rolePermissionList.forEach(r -> {
                    authorities.add(r.getPermissionName());
                });
            }
            userPrincipal.setUserId(employee.getEmployeeId());
            userPrincipal.setUserName(employee.getUserName());
            userPrincipal.setUserPassword(employee.getPassword());
            userPrincipal.setCompanyId(employee.getCompany().getCompanyId());
            userPrincipal.setAuthorities(authorities.stream().collect(Collectors.toList()));
            return userPrincipal;
        }
        return userPrincipal;
    }
}
