package com.example.ToDoApplication.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "todoItems")
public class TodoItem implements Serializable {

    @Id
    private Long id;

    private String title;

    private String creationDate;

    private String listOfTodos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getListOfTodos() {
        return listOfTodos;
    }

    public void setListOfTodos(String listOfTodos) {
        this.listOfTodos = listOfTodos;
    }

    @Override
    public String toString() {
        return  String.format("TodoItem{id = %d, title = '%s', creationDate = '%s', " +
                "listOfTodos = '%s'}", id,title,creationDate,listOfTodos);
    }
}
