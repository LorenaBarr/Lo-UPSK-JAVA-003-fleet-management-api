package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import com.example.demo.repositories.TaxiRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;




@SpringBootTest
@AutoConfigureMockMvc

class ApiTaxisApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaxiRepository taxiRepository;





    @Test
    @DisplayName("Probando el primer endpoint: Tex...")
    void context() throws Exception {
        mockMvc.perform(get("/taxi/all?page=1")).andExpect(status().isOk());

    }

    @Test
    @DisplayName("test Trajectories")
    void testControllerTrajectories() throws Exception {
        String taxi_id = "6418";
        String dateString = "2008-02-02";
        String intPage ="0";
        String pageSize = "10";

        MvcResult mvcResult = this.mockMvc.perform(get("/trajectories/byDateAndId")
                        .param("taxi_id", taxi_id)
                        .param("date", dateString)
                        .param("intPage", intPage)
                        .param("pageSize", pageSize))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pageable.pageNumber").value(intPage))
                .andExpect(jsonPath("$.pageable.pageSize").value(pageSize))
                .andReturn();
        assertEquals("application/json", mvcResult.getResponse().getContentType());

    }

}