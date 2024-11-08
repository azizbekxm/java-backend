package com.epam.restservice.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Long id;

    @Before
    public void before() {
        Employee e = new Employee("Olga", "Spresova", "olga.spresova@gmail.com");
        employeeRepository.save(e);
        id = e.getId();
    }

    @After
    public void after() {
        employeeRepository.deleteAll();
    }

    @Test
    public void findAllTest() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        Employee e = employees.get(0);
        assertEquals("Olga", e.getFirstName());
    }

    @Test
    public void findByIdTest() {
        Employee e = employeeRepository.findById(id).get();
        assertEquals("Olga", e.getFirstName());
    }

    @Test
    public void deleteByIdTest() {
        employeeRepository.deleteById(id);
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        assertEquals(0, employees.size());
    }


}
