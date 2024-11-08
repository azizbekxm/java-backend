package com.epam.restservice.services;

import com.epam.restservice.jpa.Employee;
import com.epam.restservice.jpa.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    private static final Long id = 1l;
    private static final Employee e =
            new Employee(id, "Ivan", "Spresov", "ivan.spresov@gmail.com");
    private static final List<Employee> employees =
            Collections.singletonList(e);


    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Before
    public void setMockOutput() {
        when(employeeRepository.findAll()).thenReturn(employees);
        when(employeeRepository.save(e)).thenReturn(e);
        Optional<Employee> optionalEmployee = Optional.of(e);
        when(employeeRepository.findById(id)).thenReturn(optionalEmployee);
        when(employeeRepository.save(e)).thenReturn(e);
        doNothing().when(employeeRepository).deleteById(id);
        doNothing().when(employeeRepository).deleteAll();
    }

    @Test
    public void getAllEmployeeTest() {
        assertEquals(employees, employeeService.getAllEmployee());
    }

    @Test
    public void createOrSaveEmployeeTest() {
        assertEquals(e, employeeService.createOrSaveEmployee(e));
    }

    @Test
    public void loadEmployeeByIdTest() {
        assertEquals(e, employeeService.loadEmployeeById(id));
    }

    @Test
    public void updateEmployeeTest() {
        assertEquals(e, employeeService.updateEmployee(e, id));
    }

    @Test
    public void deleteTest() {
        employeeService.delete(id);
    }

    @Test
    public void deleteAllTest() {
        employeeService.deleteAll();
    }
}
