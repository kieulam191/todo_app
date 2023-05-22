package com.example.todo.entity;

import com.example.todo.utils.DateTimeUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "todo_item")
@NoArgsConstructor
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @NotEmpty(message = "Description is required")
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private String createdDate;

    @Getter
    @Setter
    private String modifiedDate;


    public TodoItem(String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = DateTimeUtils.getDateNow();
        this.modifiedDate = DateTimeUtils.getDateNow();
    }

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description=%s, complete=%s, createdDate=%s, modifiedDate=%s}",
                this.id, this.description, this.createdDate, this.modifiedDate);
    }
}
