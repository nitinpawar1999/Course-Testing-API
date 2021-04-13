package com.courses;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.courses.Model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class Spring1ApplicationTests {

    @Autowired
    private MockMvc mvc;

	@Test
    public void test_case1() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/courses")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    public void test_case2() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/courses")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].courseName").value("Python"));
    }

    @Test
    public void test_case3() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/courses/{id}", 1L)
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("courseName").value("Python"))
        .andExpect(MockMvcResultMatchers.jsonPath("courseDescription").value("Beginner Bootcamp for Python"))
        .andExpect(MockMvcResultMatchers.jsonPath("coursePrice").value("34.45"))
        .andExpect(MockMvcResultMatchers.jsonPath("rating").value("4.5"))
        .andExpect(MockMvcResultMatchers.jsonPath("authorName").value("Rey Hayes"));
    }

    @Test
    public void test_case4() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/courses")
        .content(asJsonString(new Course(4, "Ruby", "Beginner Bootcamp for Ruby", "49.99", "4.0", "Nitin Pawar")))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    

    @Test
    public void test_case5() throws Exception{
        mvc.perform(MockMvcRequestBuilders.put("/courses")
        .content(asJsonString(new Course(4, "Ruby", "Beginner Bootcamp for Ruby", "99.99", "4.0", "Nitin Pawar")))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    public void test_case6() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("/courses/{id}", 4L))
        .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch(Exception e){
            throw new RuntimeException();
        }
    }
}
