package com.example.study.repository;

import com.example.study.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {

    Token findByToken(String token);

    Token findByUserId(Integer userId);
}
