package com.example.todo.config;

import com.example.todo.entity.TodoItem;
import com.example.todo.repository.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//method run

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if(todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("learn English");
            TodoItem todoItem2 = new TodoItem("watch football");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }

        logger.info("number of item in TodoItemRepository: " + todoItemRepository.count());
    }


}
