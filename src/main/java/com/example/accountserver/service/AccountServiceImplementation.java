package com.example.accountserver.service;

import com.example.accountserver.dao.AccountServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImplementation implements AccountService {

    private final AccountServiceRepository repository;

    @Override
    @Cacheable(cacheNames = "amount", key = "#id")
    public Long getAmount(Integer id) {
        return repository.getAmount(id);
    }

    @Override
    @CacheEvict(value = "amount", key = "#id")
    public void addAmount(Integer id, Long value) {
        repository.addAmount(id, value);
    }

}
