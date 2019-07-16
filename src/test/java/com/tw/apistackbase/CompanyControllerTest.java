package com.tw.apistackbase;

import com.tw.apistackbase.controller.CompanyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private CompanyController companyController;
    private CompanyRepository mockCompanyRepository;

    @Test
    public void should_return_companies_when_request_all_companies_api() throws Exception {
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        List<Company> mockCompanyList = new ArrayList<>();
        mockCompanyList.add(new Company("oocl", 30, new EmployeeRepository().getEmployees()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);

        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "\t{\n" +
                        "\t\t\"companyName\":\"oocl\",\n" +
                        "\t\t\"employeesNumber\": 30,\n" +
                        "\t\t\"employees\": [\n" +
                        "\t\t\t{\n" +
                        "\t\t\t\t\"id\":1,\n" +
                        "\t\t\t\t\"name\":\"a\",\n" +
                        "\t\t\t\t\"age\":10,\n" +
                        "\t\t\t\t\"gender\":\"male\",\n" +
                        "\t\t\t\t\"salary\":6000\n" +
                        "\t\t\t},\n" +
                        "\t\t\t{\n" +
                        "\t\t\t\t\"id\":2,\n" +
                        "\t\t\t\t\"name\":\"b\",\n" +
                        "\t\t\t\t\"age\":20,\n" +
                        "\t\t\t\t\"gender\":\"female\",\n" +
                        "\t\t\t\t\"salary\":8000\n" +
                        "\t\t\t}\n" +
                        "\t\t]\n" +
                        "\t}\n" +
                        "]\n"));
    }

//    @Test
//    public void should_return_company_when_request_create_a_company_api() throws Exception {
//        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
//        List<Company> mockCompanyList = new ArrayList<>();
//        mockCompanyList.add(new Company("oocl", 30, new EmployeeRepository().getEmployees()));
//        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanyList);
//
//        mockMvc.perform(get("/companies"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json("[\n" +
//                        "\t{\n" +
//                        "\t\t\"companyName\":\"oocl\",\n" +
//                        "\t\t\"employeesNumber\": 30,\n" +
//                        "\t\t\"employees\": [\n" +
//                        "\t\t\t{\n" +
//                        "\t\t\t\t\"id\":1,\n" +
//                        "\t\t\t\t\"name\":\"a\",\n" +
//                        "\t\t\t\t\"age\":10,\n" +
//                        "\t\t\t\t\"gender\":\"male\",\n" +
//                        "\t\t\t\t\"salary\":6000\n" +
//                        "\t\t\t},\n" +
//                        "\t\t\t{\n" +
//                        "\t\t\t\t\"id\":2,\n" +
//                        "\t\t\t\t\"name\":\"b\",\n" +
//                        "\t\t\t\t\"age\":20,\n" +
//                        "\t\t\t\t\"gender\":\"female\",\n" +
//                        "\t\t\t\t\"salary\":8000\n" +
//                        "\t\t\t}\n" +
//                        "\t\t]\n" +
//                        "\t}\n" +
//                        "]\n"));
//    }
}
