package com.example.study.repository.impl;

import com.example.study.model.Employee;
import com.example.study.repository.EmployeeRepositoryCustom;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
    @Autowired
    @Qualifier(value = "entityManagerFactory")
    private SessionFactory sessionFactory;

    @Override
    public Employee create(Employee employee) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.save(employee);
        }catch (HibernateException e){
            throw e;
        }
        return employee;
    }


    @Override
    public void update(Employee employee) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Optional.ofNullable(employee).ifPresent(session::evict);
            session.saveOrUpdate(employee);
        }catch (HibernateException e){
            throw e;
        }
    }
}
