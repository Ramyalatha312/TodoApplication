package com.example.ToDoApplication.services;

import com.example.ToDoApplication.models.TodoItem;
import com.example.ToDoApplication.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getItemById(Long id) {
        return  todoItemRepository.findById(id);
    }

    public TodoItem save(TodoItem todoItem) {
        return  todoItemRepository.save(todoItem);
    }

    public  void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }
}

