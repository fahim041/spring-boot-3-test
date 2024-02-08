package com.test.customer;

import com.test.exception.DuplicateResourceException;
import com.test.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jdbc") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomer(Long id){
        return customerDao.selectCustomerById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        if(customerDao.existsPersonWithEmail(customerRegistrationRequest.email())){
            throw new DuplicateResourceException("Email already exist");
        }
        customerDao.insertCustomer(new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.age()
        ));
    }

    public void deleteCustomer(Long id){
        if(!customerDao.existsPersonWithId(id)){
            throw new ResourceNotFoundException("Customer not found");
        }
        customerDao.deleteCustomer(id);
    }
}
