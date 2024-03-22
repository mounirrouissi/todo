package com.todo.demo.controller;

import com.todo.demo.dto.TodoDto;
import com.todo.demo.models.Todo;
import com.todo.demo.service.TodoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @MockBean
    TodoService todoService;
    @Autowired
    MockMvc mvc;

//    @Mock
//    private TodoService todoService;
//    @InjectMocks
//    TodoController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @org.junit.jupiter.api.Test
    void getTodos() throws Exception {
     //given
        List<TodoDto> expected = new ArrayList<>(
                List.of(
                        new TodoDto(1,"Pray",false),
                        new TodoDto(2,"Pray",true),
                        new TodoDto(3,"Pray",false)

                ));

        //when
        when(todoService.getTodos()).thenReturn(expected);
        //then

     //   Assertions.assertThat(controller.getTodos()).isEqualTo(expected);
        mvc.perform(get("/api/v1/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))

                .andExpect(jsonPath("$[0].id", is(1)))
                ;




    }
}