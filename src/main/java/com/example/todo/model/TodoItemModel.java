package com.example.todo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
public class TodoItemModel {

    @Getter
    @Setter
    private long taskId;

    @Getter
    @Setter
    @NotEmpty
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private Instant createdDate;

    @Getter
    @Setter
    private Instant modifiedDate;

}
