package com.example.todo.repository;

import com.example.todo.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;

//important: CrudRepository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
}
