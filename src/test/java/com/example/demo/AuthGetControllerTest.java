package com.example.demo;

import com.example.demo.dto.LoginUser;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static com.example.demo.utils.UtilCredentials.ADMIN_EMAIL;
import static com.example.demo.utils.UtilCredentials.ADMIN_PASSWORD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthGetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private final Faker faker = new Faker();



    @Test
    void shouldReturnUser() throws Exception {
        mockMvc.perform(get("/login?email="+ ADMIN_EMAIL+"&password="+ADMIN_PASSWORD))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("admin@gmail.com"))
                .andExpect(jsonPath("$.firstname").value("Admin"))
                .andExpect(jsonPath("$.lastname").value("Adminov"))
                .andExpect(jsonPath("$.roleName").value("ADMIN"));
    }

    @Test
    void shouldReturn400WrongEmail() throws Exception {
        mockMvc.perform(get("/login?email="+ faker.name().name()+"&password="+ADMIN_PASSWORD))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400EmptyPassword() throws Exception {
        mockMvc.perform(get("/login?email="+ ADMIN_EMAIL+"&password="))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn401UnexistedEmail() throws Exception {
        mockMvc.perform(get("/login?email="+ faker.internet().emailAddress() +"&password="+ADMIN_PASSWORD))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void shouldReturn401WrongPassword() throws Exception {
        mockMvc.perform(get("/login?email="+ ADMIN_EMAIL+"&password="+faker.internet().password()))
                .andExpect(status().isUnauthorized());
    }
}
