package com.example.india.demo.api;

import com.example.india.demo.dto.EmployeeDto;
import com.example.india.demo.service.GeneralService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class DemoApiTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GeneralService generalService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void getDemoDetails() throws Exception {
        when(generalService.getDemoDetails()).thenReturn(Collections.singletonList(EmployeeDto.builder().id(101).build()));

        mvc.perform(get("/demo/details").header("dcNumber", "4008")
                .header("dcName", "india")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}