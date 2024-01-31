package com.SpringBoot.TodoManagement.Service.impl;

import com.SpringBoot.TodoManagement.Dto.TodoDto;
import com.SpringBoot.TodoManagement.Entity.Todo;
import com.SpringBoot.TodoManagement.Exception.ResourceNotFoundException;
import com.SpringBoot.TodoManagement.Repository.TodoRepository;
import com.SpringBoot.TodoManagement.Service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository; //Service impl Requires Constructor based Repository as dependency

    private ModelMapper modelMapper; //model mapper dependency
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //convert TodoDto into Todo Entity
        //without model mapper it takes too much code
        //to covert entity into Dto
        //Todo todo = new Todo();
        // todo.setTitle(todoDto.getTitle());
        //todo.setDescription(todoDto.getDescription());
        //todo.setCompleted(todoDto.isCompleted());

        //convert TodoDto into Todo Entity with ModelMapper Library
        Todo todo = modelMapper.map(todoDto, Todo.class);

        //Todo Jpa Entity
        Todo savedTodo = todoRepository.save(todo);

        //convert Todo Entity into TodoDto without Model Mapper
        //Convert savedTodo Jpa entity into TodoDto Object
        //TodoDto savedTodoDto = new TodoDto();
        //savedTodoDto.setTitle(savedTodo.getTitle());
        //savedTodoDto.setDescription(savedTodo.getDescription());
        //savedTodoDto.setCompleted(savedTodo.isCompleted());

        //convert Todo entity into TodoDto with ModelMapper Library
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);


        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        todo.setCompleted(Boolean.FALSE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}
