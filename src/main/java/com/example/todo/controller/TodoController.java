package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/backlog")
    public ResponseEntity<List<Todo>> getBacklog() {
        return ResponseEntity.ok(service.getBacklog());
    }

    @GetMapping("/today")
    public ResponseEntity<List<Todo>> getToday() {
        return ResponseEntity.ok(service.getToday());
    }

    @PostMapping("/{id}/assign")
    public ResponseEntity<Void> assignToToday(@PathVariable Long id) {
        service.assignToToday(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<Void> markComplete(@PathVariable Long id) {
        service.markComplete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createTodo(@RequestBody String title) {
        service.create(title);
        return ResponseEntity.ok().build();
    }
}
