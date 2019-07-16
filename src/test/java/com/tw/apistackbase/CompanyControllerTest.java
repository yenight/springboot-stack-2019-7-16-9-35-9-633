package com.tw.apistackbase;

import com.tw.apistackbase.controller.CompanyController;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyController companyController;

    @MockBean
    private CompanyRepository mockCompanyRepository;

    @Test
    public void should_return_companies_when_request_all_companies_api() throws Exception {
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1001, "oocl", 30, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1001,\n" +
                        "        \"companyName\": \"oocl\",\n" +
                        "        \"employeesNumber\": 30,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 0,\n" +
                        "        \"companyName\": \"a\",\n" +
                        "        \"employeesNumber\": 10,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"companyName\": \"b\",\n" +
                        "        \"employeesNumber\": 20,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"companyName\": \"c\",\n" +
                        "        \"employeesNumber\": 30,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"companyName\": \"d\",\n" +
                        "        \"employeesNumber\": 40,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 4,\n" +
                        "        \"companyName\": \"e\",\n" +
                        "        \"employeesNumber\": 50,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 5,\n" +
                        "        \"companyName\": \"f\",\n" +
                        "        \"employeesNumber\": 60,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_company_when_request_request_a_company_api() throws Exception {
        Company company = new Company(1001, "oocl", 30, new EmployeeRepository().getEmployees());
        Mockito.when(mockCompanyRepository.getCompaniesById(1001)).thenReturn(company);

        mockMvc.perform(get("/companies/1001"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1001,\n" +
                        "    \"companyName\": \"oocl\",\n" +
                        "    \"employeesNumber\": 30,\n" +
                        "    \"employees\": [\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"a\",\n" +
                        "            \"age\": 10,\n" +
                        "            \"gender\": \"male\",\n" +
                        "            \"salary\": 6000\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"b\",\n" +
                        "            \"age\": 20,\n" +
                        "            \"gender\": \"female\",\n" +
                        "            \"salary\": 8000\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }

    @Test
    public void should_return_employees_when_request_request_a_company_api() throws Exception {
        Mockito.when(mockCompanyRepository.getCompanyEmployeesById(1001)).thenReturn(new EmployeeRepository().getEmployees());

        mockMvc.perform(get("/companies/1001/employees"))
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
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_some_companies_when_request_request_page_and_pageSize_api() throws Exception {
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1001, "oocl", 30, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(0, "a", 10, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(1, "b", 20, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(2, "c", 30, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(3, "d", 40, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(4, "e", 50, new EmployeeRepository().getEmployees()));
        mockCompanyList.add(new Company(5, "f", 60, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(get("/companies?page=1&pageSize=4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 0,\n" +
                        "        \"companyName\": \"a\",\n" +
                        "        \"employeesNumber\": 10,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"companyName\": \"b\",\n" +
                        "        \"employeesNumber\": 20,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_company_when_request_create_a_company_api() throws Exception {
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1001, "oocl", 30, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(post("/companies")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content("{\n" +
                    "    \"companyName\": \"oocl2\",\n" +
                    "    \"employeesNumber\": 50,\n" +
                    "    \"employees\": null\n" +
                    "}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 7,\n" +
                        "    \"companyName\": \"oocl2\",\n" +
                        "    \"employeesNumber\": 50,\n" +
                        "    \"employees\": null\n" +
                        "}"));
    }

    @Test
    public void should_return_company_when_request_update_a_company_api() throws Exception {
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1001, "oocl", 30, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(put("/companies/3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "\t\"companyName\": \"666\"\n" +
                        "}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 3,\n" +
                        "    \"companyName\": \"666\",\n" +
                        "    \"employeesNumber\": 0,\n" +
                        "    \"employees\": null\n" +
                        "}"));
    }

    @Test
    public void should_return_new_all_company_when_request_delete_a_company_api() throws Exception {
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company(1001, "oocl", 30, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(delete("/companies/1001"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 0,\n" +
                        "        \"companyName\": \"a\",\n" +
                        "        \"employeesNumber\": 10,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"companyName\": \"b\",\n" +
                        "        \"employeesNumber\": 20,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"companyName\": \"c\",\n" +
                        "        \"employeesNumber\": 30,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"companyName\": \"d\",\n" +
                        "        \"employeesNumber\": 40,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 4,\n" +
                        "        \"companyName\": \"e\",\n" +
                        "        \"employeesNumber\": 50,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 5,\n" +
                        "        \"companyName\": \"f\",\n" +
                        "        \"employeesNumber\": 60,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"a\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"b\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }


}
