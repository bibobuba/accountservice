package com.example.accountserver.controller;

import com.example.accountserver.service.AccountServiceImplementation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountServiceController {

    private final AccountServiceImplementation service;

    @PutMapping("/account/{id}/replenishment/{amount}")
    public void putValue(@PathVariable(name = "id") Integer id,
                         @PathVariable(name = "amount") Long amount) {
        service.addAmount(id, amount);
        log.info("Putting value = " + amount + " for id = " + id);
    }

    @GetMapping("/account/{id}")
    public Long getValue(@PathVariable(name = "id") Integer id) {
        log.info("Getting amount for id: " + id);
        return service.getAmount(id);
    }

}
