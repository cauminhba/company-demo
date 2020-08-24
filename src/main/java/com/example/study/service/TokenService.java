package com.example.study.service;

import com.example.study.model.Token;
import com.example.study.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Transactional
    public Token createToken(Token token){
        return tokenRepository.saveAndFlush(token);
    }

    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public Token findByUserId(Integer employeeId) {
        return tokenRepository.findByUserId(employeeId);
    }

    public void deleteToken(Token token){
        tokenRepository.delete(token);
    }
}
