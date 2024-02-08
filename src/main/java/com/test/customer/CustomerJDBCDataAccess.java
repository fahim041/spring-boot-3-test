package com.test.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CustomerJDBCDataAccess implements CustomerDao{

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    public CustomerJDBCDataAccess(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        var sql = """
                SELECT id, name, email, age
                from customer
                """;

        return jdbcTemplate.query(sql, customerRowMapper);
    }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        var sql = """
                SELECT id, name, email, age
                from customer
                where id = ?
                """;
        return jdbcTemplate.query(sql, customerRowMapper, id)
                .stream().findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        var sql = """
                INSERT INTO customer(name, email, age)
                VALUES (?, ?, ?)
                """;
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getAge());
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return false;
    }

    @Override
    public boolean existsPersonWithId(Long id) {
        return false;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
