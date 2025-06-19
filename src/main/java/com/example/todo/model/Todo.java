package com.example.todo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String tag;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;


    @Column(name = "created_at")
    private LocalDateTime createdOn;

    @Column(name = "completed_at")
    private LocalDateTime completedOn;
}
