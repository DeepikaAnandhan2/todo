package com.sample.todo.controller;

import com.sample.todo.repository.TodoRepository;
import com.sample.todo.service.TodoService;
import com.sample.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/todo")
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;
    private TodoRepository todoRepository;

//    @GetMapping("/get")
//    String getTodo(){
//        return "Todo";
//    }

    //using PathVariable
    @GetMapping("/{id}")
    ResponseEntity<?> getTodoById(@PathVariable long id){

        try {
            Todo createdTodo = todoService.getTodoById(id);
            return new ResponseEntity<>(createdTodo, HttpStatus.OK);
        }
        catch(RuntimeException e){
            String m="Todo with ID "+id+" not found!";
            return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<List<Todo>>(todoService.getTodos(), HttpStatus.OK);
    }

//    //using RequestParam
//
//    @GetMapping
//    String getTodoByIdParam(@RequestParam long id){
//        return "Todo with Id: "+id;
//    }

    @PostMapping("/create")
    ResponseEntity<Todo> create(@RequestBody Todo todo){

            Todo createdTodo = todoService.createTodo(todo);
            return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);

      }

      @PutMapping("/{id}")
      ResponseEntity<Todo> updateTodoById(@PathVariable long id, @RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
      }

      @DeleteMapping("/{id}")
      void deleteTodoById(@PathVariable long id){
        todoService.deleteTodoById(id);
      }

      @GetMapping("/pages")
      ResponseEntity<Page<Todo>> getTodosPaged(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(todoService.getAllTodosPages(page, size), HttpStatus.OK);
      }

}










