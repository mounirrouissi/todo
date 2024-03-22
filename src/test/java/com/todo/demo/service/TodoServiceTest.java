package com.todo.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import com.todo.demo.dto.TodoDto;
import com.todo.demo.models.Todo;
import com.todo.demo.repos.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getTodos_ShouldReturnListOfTodoDtos() {
        // Arrange
        List<Todo> todos = Arrays.asList(new Todo("Task 1",false), new Todo("Task 2",false));
        when(todoRepository.findAll()).thenReturn(todos);

        // Act
        List<TodoDto> result = todoService.getTodos();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).description());
        assertEquals("Task 2", result.get(1).description());
    }
}
