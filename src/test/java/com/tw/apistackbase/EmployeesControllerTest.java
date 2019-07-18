package com.tw.apistackbase;

import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeRepository mockEmployeeRepository;

    @Test
    public void should_return_employees_when_request_all_employees_api() throws Exception {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1001, "vv", 40, "male", 5000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployees);

        mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"a\",\n" +
                        "        \"age\": 10,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 6000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"b\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 8000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"c\",\n" +
                        "        \"age\": 30,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 9000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_employee_when_request_a_employee_api() throws Exception {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1001, "vv", 40, "male", 5000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployees);

        mockMvc.perform(get("/employees/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"a\",\n" +
                        "    \"age\": 10,\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"salary\": 6000\n" +
                        "}"));
    }

    @Test
    public void should_return_employees_when_request_page_and_pageSize_api() throws Exception {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1001, "vv", 40, "male", 5000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployees);

        mockMvc.perform(get("/employees?page=1&pageSize=3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"b\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 8000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_employees_when_request_gender_is_male_api() throws Exception {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1001, "vv", 40, "male", 5000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployees);

        mockMvc.perform(get("/employees?gender=male"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"a\",\n" +
                        "        \"age\": 10,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 6000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"c\",\n" +
                        "        \"age\": 30,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 9000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_employee_when_request_create_an_employee_api() throws Exception {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1001, "vv", 40, "male", 5000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployees);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "    \"name\": \"nnn\",\n" +
                        "    \"age\": 34,\n" +
                        "    \"gender\": \"female\",\n" +
                        "    \"salary\": 10000\n" +
                        "}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 3,\n" +
                        "    \"name\": \"nnn\",\n" +
                        "    \"age\": 34,\n" +
                        "    \"gender\": \"female\",\n" +
                        "    \"salary\": 10000\n" +
                        "}"));
    }

    @Test
    public void should_return_employee_when_request_update_an_employee_api() throws Exception {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1001, "vv", 40, "male", 5000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployees);

        mockMvc.perform(put("/employees/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "    \"name\": \"666\",\n" +
                        "    \"age\": 22,\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"salary\": 1000\n" +
                        "}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"666\",\n" +
                        "    \"age\": 22,\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"salary\": 1000\n" +
                        "}"));
    }

    @Test
    public void should_return_new_employees_when_request_delete_a_employee_api() throws Exception {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1001, "vv", 40, "male", 5000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployees);

        mockMvc.perform(delete("/employees/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"b\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 8000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"c\",\n" +
                        "        \"age\": 30,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 9000\n" +
                        "    }\n" +
                        "]"));
    }
}
