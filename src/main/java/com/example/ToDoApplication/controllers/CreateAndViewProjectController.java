package com.example.ToDoApplication.controllers;

import com.example.ToDoApplication.models.TodoItem;
import com.example.ToDoApplication.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class CreateAndViewProjectController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/createTodo")
    public String showCreationForm(TodoItem todoItem) {
        return "CreateProject";
    }

    @PostMapping("/todo")
    public String createTodo(@Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = new TodoItem();
        item.setId(todoItem.getId());
        item.setTitle(todoItem.getTitle());
        item.setListOfTodos(todoItem.getListOfTodos());
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        item.setCreationDate(localDateTime.format(dateTimeFormatter));
        todoItemService.save(item);
        return  "redirect:/";
    }

    @GetMapping("/viewProject")
    public String showProjectDetails(TodoItem todoItem) {
        return "ViewProject";
    }

    @GetMapping("/backToHome")
    public ModelAndView backToHome() {
        ModelAndView modelAndView = new ModelAndView("HomePage");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }

}
