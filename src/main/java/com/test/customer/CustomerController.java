package com.test.customer;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping("/")
    public void addCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        customerService.addCustomer(customerRegistrationRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }
}
