package com.example.todo.service;

import com.example.todo.model.TodoItemModel;
import com.example.todo.model.TodoPojo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseConfigService {
    public ResponseEntity<?> responseConfig(ResponseEntity<?> entity) {
        if(entity.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>(new TodoPojo("success", entity.getBody(), 200), entity.getStatusCode());
        } else {
            return new ResponseEntity<>(new TodoPojo("failure", entity.getBody(), 500), entity.getStatusCode());
        }
    }
}
