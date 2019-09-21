package com.example.accountserver.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class AccountServiceRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void addAmount(Integer id, Long value) {
        jdbcTemplate.update(" INSERT INTO accounts(id,amount) values(?,?)\n" +
                        " ON CONFLICT (id)\n" +
                        " DO UPDATE SET amount = EXCLUDED.amount;",
                id, value);
    }

    @Transactional
    public Long getAmount(Integer id) {
        return jdbcTemplate.query("SELECT amount FROM accounts WHERE id = ?",
                rs -> rs.next() ? rs.getLong("amount") : 0L, id);
    }
}
