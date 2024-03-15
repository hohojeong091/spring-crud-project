package com.example.springcrudproject.crud.menu.controller;

import com.example.springcrudproject.SpringCrudProjectApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@ContextConfiguration(classes = {SpringCrudProjectApplication.class})
public class MenuControllerTests {

    @Autowired
    private MenuController menuController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(menuController).build();
    }


    @Test
    public void 전체_책조회() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/menu/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("menu/list"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    public void 신규_책등록() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("bookName", "dkdkdkdk");
        params.add("autourName", "ahahahah");
        params.add("pubName", "aa1000");
        params.add("catNum", "100");
        params.add("ability", "Y");

        mockMvc.perform(MockMvcRequestBuilders.post("/menu/regist").params(params))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/menu/list"))
                .andDo(MockMvcResultHandlers.print());


    }
}


