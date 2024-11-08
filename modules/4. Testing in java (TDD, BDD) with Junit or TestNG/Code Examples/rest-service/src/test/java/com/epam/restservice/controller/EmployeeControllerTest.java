package com.epam.restservice.controller;

import com.epam.restservice.jpa.Employee;
import com.epam.restservice.services.EmployeeService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson = new Gson();
    private final static Long id = 1l;
    private final static Employee e =
            new Employee(id, "Ivan", "Spresov", "ivan.spresov@gmail.com");
    private final static List<Employee> employees = Collections.singletonList(e);

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getAllEmployeesTest() throws Exception {
        when(employeeService.getAllEmployee()).thenReturn(employees);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/employees")
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        String content = result.getResponse().getContentAsString();
        List employeesObj = gson.fromJson(content, List.class);
        Object obj = employeesObj.get(0);
        Employee employee = gson.fromJson(obj.toString(), Employee.class);
        assertEquals("Ivan", employee.getFirstName());
    }

    @Test
    public void createOrSaveEmployeeTest() throws Exception {
        when(employeeService.createOrSaveEmployee(any(Employee.class))).thenReturn(e);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employees")
                        .content(gson.toJson(e))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();
        String content = result.getResponse().getContentAsString();
        Employee employee = gson.fromJson(content, Employee.class);
        assertEquals("Ivan", employee.getFirstName());
    }

    @Test
    public void getEmployeeByIdTest() throws Exception {
        when(employeeService.loadEmployeeById(id)).thenReturn(e);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/employees/{id}", id)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        String content = result.getResponse().getContentAsString();
        Employee employee = gson.fromJson(content, Employee.class);
        assertEquals("Ivan", employee.getFirstName());
    }

    @Test
    public void updateEmployeeTest() throws Exception {
        when(employeeService.updateEmployee(any(Employee.class), any(Long.class))).thenReturn(e);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/employees/{id}", id)
                .content(gson.toJson(e))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        String content = result.getResponse().getContentAsString();
        Employee employee = gson.fromJson(content, Employee.class);
        assertEquals("Ivan", employee.getFirstName());
    }

    @Test
    public void deleteEmployeeTest() throws Exception {
        doNothing().when(employeeService).delete(id);
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/employees/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAllTest() throws Exception {
        doNothing().when(employeeService).deleteAll();
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/employees")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
