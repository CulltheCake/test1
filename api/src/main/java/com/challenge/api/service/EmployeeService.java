package com.challenge.api.service;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    
    Employee getEmployeeByUuid(UUID uuid);
    Employee createEmployee(CreateEmployeeRequest request);
}
