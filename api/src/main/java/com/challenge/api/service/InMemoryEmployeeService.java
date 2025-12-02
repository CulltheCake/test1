package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.DefaultEmployee; // if you have this
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class InMemoryEmployeeService implements EmployeeService {

    private final List<Employee> employees = new CopyOnWriteArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        return List.copyOf(employees);
    }

    @Override
    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.stream()
                .filter(e -> e.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setUuid(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }
}
