// package com.example.helloworld.controller;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.web.servlet.MockMvc;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @SpringBootTest
// @AutoConfigureMockMvc
// class HelloWorldControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @Test
//     void shouldReturnExpectedMessage() throws Exception {

//         mockMvc.perform(get("/hello"))
//                 .andExpect(status().isOk())
//                 .andExpect(content().string("Hello, World!"));
//     }
// }

package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGreet() throws Exception {
        mockMvc.perform(get("/api/greet").param("name", "Alice"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Alice")));
    }

    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(post("/api/login")
                .param("user", "admin")
                .param("pass", "SuperSecretPassword"))
               .andExpect(status().isOk())
               .andExpect(content().string("Login successful"));
    }

    @Test
    void testLoginFailure() throws Exception {
        mockMvc.perform(post("/api/login")
                .param("user", "admin")
                .param("pass", "wrong"))
               .andExpect(status().isOk())
               .andExpect(content().string("Login failed"));
    }

    @Test
    void testHash() throws Exception {
        mockMvc.perform(get("/api/hash").param("password", "test"))
               .andExpect(status().isOk())
               .andExpect(content().string(not(isEmptyString())));
    }

    @Test
    void testUserById() throws Exception {
        // No actual data in H2 → empty body OK
        mockMvc.perform(get("/api/userById").param("id", "1"))
               .andExpect(status().isOk());
    }
}