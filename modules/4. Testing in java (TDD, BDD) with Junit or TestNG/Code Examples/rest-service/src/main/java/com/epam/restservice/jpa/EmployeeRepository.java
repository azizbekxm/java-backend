package com.epam.restservice.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Employee repository
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    /**
     * Find by Last name
     * @param lastName <code>String</code> 
     * @return
     */
    List<Employee> findByLastName(String lastName);
    Employee findById(long id);
}
