package com.example.study.repository.impl;

import com.example.study.model.Company;
import com.example.study.repository.CompanyRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyRepositoryImpl implements CompanyRepositoryCustom {

    @Autowired
    @Qualifier(value = "entityManagerFactory")
    private SessionFactory sessionFactory;

    @Override
    public void create(Company company) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.save(company);
        }catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public void update(Company company) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Optional.ofNullable(company).ifPresent(session::evict);
            session.saveOrUpdate(company);
        }catch (HibernateException e){
            throw e;
        }
    }
}
