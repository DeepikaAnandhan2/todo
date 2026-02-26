package com.sample.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

//we have to create todo table
@Entity
@Data
    public class Todo {
    @Id
    @GeneratedValue //when creating the table the column rollno willbe created automatically
    long id;
    String title;

    String Description;
    Boolean isCompleted;


}
