package com.example.todos.service;

import com.example.todos.entity.Todo;
import com.example.todos.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    public Todo update(Long id, Todo updated) {
        Todo existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        existing.setTitle(updated.getTitle());
        existing.setCompleted(updated.isCompleted());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
