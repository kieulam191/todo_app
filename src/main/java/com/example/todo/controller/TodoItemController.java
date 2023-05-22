package com.example.todo.controller;

import com.example.todo.model.TodoItemModel;
import com.example.todo.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("v1/api")
public class TodoItemController {

    @Autowired
    TodoItemService todoItemService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TodoItemModel>> index() {
        return todoItemService.getAllTask();
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<TodoItemModel> findTaskById(@PathVariable("id") long id) {
       return todoItemService.findTaskById(id);
    }

    @PutMapping("tasks/{id}/update")
    public void updateTaskById(@PathVariable("id") long id, @RequestBody() TodoItemModel updateTask) {
        todoItemService.update(id, updateTask);
    }

    @DeleteMapping("tasks/{id}/delete")
    public void deleteTaskById(@PathVariable("id") long id) {
        todoItemService.deleteTaskById(id);
    }

    @PostMapping("/new-task")
    public void createTask(@RequestBody String description) {
        todoItemService.createTask(description);
    }
}
