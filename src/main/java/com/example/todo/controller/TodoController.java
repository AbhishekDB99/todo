package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(service.getAllTodos());
    }


    @GetMapping("/backlog")
    public ResponseEntity<List<Todo>> getBacklog() {
        return ResponseEntity.ok(service.getBacklog());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> getCompleted() {
        return ResponseEntity.ok(service.getCompleted());
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

    @PostMapping("/{id}/reopen")
    public ResponseEntity<Void> reopen(@PathVariable Long id) {
        service.reopen(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping
    public ResponseEntity<Void> createTodo(@RequestBody TodoRequest request) {
        service.create(request.title());
        return ResponseEntity.ok().build();
    }

    public record TodoRequest(String title) {}

}
