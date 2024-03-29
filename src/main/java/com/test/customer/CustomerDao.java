package com.test.customer;

import java.util.Optional;
import java.util.List;

public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Long id);
    void insertCustomer(Customer customer);
    boolean existsPersonWithEmail(String email);
    boolean existsPersonWithId(Long id);
    void deleteCustomer(Long id);
}
