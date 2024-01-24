package com.SpringBoot.TodoManagement.Service.impl;

import com.SpringBoot.TodoManagement.Dto.TodoDto;
import com.SpringBoot.TodoManagement.Entity.Todo;
import com.SpringBoot.TodoManagement.Repository.TodoRepository;
import com.SpringBoot.TodoManagement.Service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository; //Service impl Requires Constructor based Repository as dependency

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //convert TodoDto into Todo Entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        //convert Todo Entity into TodoDto
        Todo savedTodo = todoRepository.save(todo);

        //Convert savedTodo Jpa entity into TodoDto Object
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());

        return savedTodoDto;
    }
}
