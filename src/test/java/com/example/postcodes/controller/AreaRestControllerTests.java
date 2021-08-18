package com.example.postcodes.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AreaRestControllerTests {

    private final MockMvc mvc;

    public AreaRestControllerTests(WebApplicationContext context) {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    private String readResourceFile(String filename) {
        return new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream(filename)))
        ).lines().collect(Collectors.joining());
    }

    @WithMockUser("user")
    @Test
    public void test_CreateAndFindPostcodes_Successful() throws Exception {
        mvc.perform(get("/api/v1/areas/findSortedNamesWithNumberOfCharactersByPostcodes")
                        .param("postcodeFrom", "6000")
                        .param("postcodeTo", "6430"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
        String postContent = readResourceFile("/areas.json");
        mvc.perform(post("/api/v1/areas/createWithList").content(postContent).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(postContent));
        mvc.perform(get("/api/v1/areas/findSortedNamesWithNumberOfCharactersByPostcodes")
                        .param("postcodeFrom", "6000")
                        .param("postcodeTo", "6430"))
                .andExpect(status().isOk())
                .andExpect(content().json(readResourceFile("/find_6000_6430.json")));
        mvc.perform(get("/api/v1/areas/findSortedNamesWithNumberOfCharactersByPostcodes")
                        .param("postcodeFrom", "6000")
                        .param("postcodeTo", "6100"))
                .andExpect(status().isOk())
                .andExpect(content().json(readResourceFile("/find_6000.json")));
    }
}
