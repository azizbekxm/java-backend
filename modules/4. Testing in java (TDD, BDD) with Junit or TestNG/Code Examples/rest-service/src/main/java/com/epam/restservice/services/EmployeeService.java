package com.epam.restservice.services;

import antlr.StringUtils;
import com.epam.restservice.jpa.Employee;
import com.epam.restservice.jpa.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployee() {
        return (List<Employee>) repository.findAll();
    }

    public Employee createOrSaveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee loadEmployeeById(Long id) {
        return repository.findById(id).get();
    }

    public Employee updateEmployee(Employee newEmployee, Long id) {
        Employee employee = repository.findById(id).get();
        if (employee == null) employee = new Employee();
        employee.setId(id);
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setEmail(newEmployee.getEmail());
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }


}
