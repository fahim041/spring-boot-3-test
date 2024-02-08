package com.test;

import com.test.customer.Customer;
import com.test.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository){
        return args -> {
            Customer user1 = new Customer("user1", "user1@gmail.com", 21);
            Customer user2 = new Customer("user2", "user2@gmail.com", 25);

//            customerRepository.save(user1);
//            customerRepository.save(user2);
        };
    }
}
