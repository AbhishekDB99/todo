package com.example.todo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.todo.model.Todo;
import com.example.todo.model.TodoStatus;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {
private static final Logger log = LoggerFactory.getLogger(TodoService.class);

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }


    public List<Todo> getBacklog() {
        return repository.findByStatus((TodoStatus.BACKLOG));
    }

    public List<Todo> getCompleted() {
        return repository.findByStatus(TodoStatus.DONE);
    }


    public List<Todo> getToday() {
        return repository.findByStatus(TodoStatus.TODAY);
    }

    public void assignToToday(Long id) {
        repository.findById(id).ifPresent(todo -> {
            todo.setStatus(TodoStatus.TODAY);
            repository.save(todo);
        });
    }

    public void markComplete(Long id) {
        repository.findById(id).ifPresent(todo -> {
            todo.setStatus(TodoStatus.DONE);
            todo.setCompletedOn(LocalDateTime.now());
            repository.save(todo);
        });
    }

    public void reopen(Long id) {
        Todo todo = repository.findById(id).orElseThrow();
        todo.setStatus(TodoStatus.TODAY);
        repository.save(todo);
    }


    public void create(String title) {
        log.info("Creating todo with title: {}", title);

        Todo todo = Todo.builder()
                .title(title)
                .status(TodoStatus.BACKLOG)
                .createdOn(LocalDateTime.now())
                .build();

        repository.save(todo);
    }
}
