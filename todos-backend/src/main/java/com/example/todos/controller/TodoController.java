package com.example.todos.controller;

import com.example.todos.entity.Todo;
import com.example.todos.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping
    public List<Todo> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Todo create(@Valid @RequestBody Todo todo) {
        return service.create(todo);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id,
                       @Valid @RequestBody Todo todo) {
        return service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
