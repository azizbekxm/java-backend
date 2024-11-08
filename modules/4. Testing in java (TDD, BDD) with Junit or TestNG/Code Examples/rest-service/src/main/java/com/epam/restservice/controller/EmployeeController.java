package com.epam.restservice.controller;

import com.epam.restservice.jpa.Employee;
import com.epam.restservice.jpa.EmployeeRepository;
import com.epam.restservice.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class
 */
@RestController
@Api(value = "Employee CRUD service", description = "Employee CRUD service")
public class EmployeeController {

    /**
     * Employee Service
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Method returns list of employee
     * @return <code>List</code>
     */
    @ApiOperation(value = "Get Employees", response = List.class)
    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    /**
     * Method create or update Employee
     * @param newEmployee new Employee
     * @return <code>Employee</code> employee
     */
    @PostMapping("/employees")
    Employee createOrSaveEmployee(@RequestBody Employee newEmployee) {
        return employeeService.createOrSaveEmployee(newEmployee);
    }

    /**
     * Get Employee by Id
     * @param id <code>Long</code> Id of Employee
     * @return <code>Employee</code> employee
     */
    @GetMapping("/employees/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.loadEmployeeById(id);
    }

    /**
     * Update Employee
     * @param newEmployee <code>Employee</code> newEmployee
     * @param id <code>Long</code> Id of Employee
     * @return
     */
    @PutMapping("/employees/{id}")
    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeService.updateEmployee(newEmployee,id);
    }

    /**
     * Delete Employee by Id
     * @param id <code>Long</code> id of Employee
     */
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

    /**
     * Delete all employee
     */
    @DeleteMapping("/employees")
    void deleteAll(){
        employeeService.deleteAll();
    }
}