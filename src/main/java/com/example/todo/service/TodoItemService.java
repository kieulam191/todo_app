package com.example.todo.service;

import com.example.todo.entity.TodoItem;
import com.example.todo.model.TodoItemModel;
import com.example.todo.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoItemService {


    @Autowired
    private TodoItemRepository todoItemRepository;

    public ResponseEntity<List<TodoItemModel>> getAllTask() {
        List<TodoItem> todoItems = (List<TodoItem>) todoItemRepository.findAll();
        ResponseEntity<List<TodoItem>> entities = new ResponseEntity<>(todoItems, HttpStatus.OK);

        ResponseEntity<List<TodoItemModel>> todoModels = convertEntityToModel(entities);
        return todoModels;
    }

    public ResponseEntity<TodoItemModel> findTaskById(long id) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));

        TodoItemModel todoItemModel = convertEntityToModel(todoItem);

        return new ResponseEntity<>(todoItemModel, HttpStatus.OK);
    }

    public void update(long id, TodoItemModel updateTodo) {
        TodoItem oldTodoItem = todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));


        TodoItem todoItem = new TodoItem();
        todoItem.setId(oldTodoItem.getId());
        todoItem.setDescription(updateTodo.getDescription());
        todoItem.setComplete(updateTodo.isComplete());
        todoItem.setModifiedDate(Instant.now());
        todoItem.setCreatedDate(oldTodoItem.getCreatedDate());
        todoItemRepository.save(todoItem);
    }

    public void deleteTaskById(long id) {
        todoItemRepository.deleteById(id);
    }

    public void createTask(String Description) {
        TodoItem newTodo = new TodoItem(Description);

        todoItemRepository.save(newTodo);
    }

    private ResponseEntity<List<TodoItemModel>> convertEntityToModel( ResponseEntity<List<TodoItem>> list) {
        List<TodoItemModel> todoItemModels = new ArrayList<>();
        int numOfTodoItem = 0;
        for (TodoItem item: list.getBody()) {
            todoItemModels.add(new TodoItemModel(
                    item.getId(),
                    item.getDescription(),
                    item.isComplete(),
                    item.getCreatedDate(),
                    item.getModifiedDate()));
        }

        return new ResponseEntity<>(todoItemModels, HttpStatus.OK);
    }

    private TodoItemModel convertEntityToModel(TodoItem item) {
        return new TodoItemModel(
                item.getId(),
                item.getDescription(),
                item.isComplete(),
                item.getCreatedDate(),
                item.getModifiedDate());
    }



}
