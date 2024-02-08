package com.test.customer;

public record CustomerRegistrationRequest(
   String name,
   String email,
   Integer age
) { }
