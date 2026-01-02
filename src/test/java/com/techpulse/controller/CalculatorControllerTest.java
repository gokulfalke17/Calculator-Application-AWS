package com.techpulse.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testServiceUp() throws Exception {
        mockMvc.perform(get("/api/calc/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Calculator Service is up and running..!"));
    }

    @Test
    void testAddition() throws Exception {
        mockMvc.perform(get("/api/calc/add")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("Addition is :: 15.0"));
    }

    @Test
    void testSubtraction() throws Exception {
        mockMvc.perform(get("/api/calc/subtract")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("Substraction is :: 5.0"));
    }

    @Test
    void testMultiplication() throws Exception {
        mockMvc.perform(get("/api/calc/multiply")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("Multiplication is :: 50.0"));
    }

    @Test
    void testDivision() throws Exception {
        mockMvc.perform(get("/api/calc/divide")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("Division is :: 2.0"));
    }

    @Test
    void testDivisionByZero() throws Exception {
        mockMvc.perform(get("/api/calc/divide")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Don't Pass Second Number as Zero.!"));
    }
}
