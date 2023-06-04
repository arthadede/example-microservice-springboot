package com.arthadede.examplemicroservice.controller;

import com.arthadede.examplemicroservice.model.Image;
import com.arthadede.examplemicroservice.model.Todo;
import com.arthadede.examplemicroservice.schema.CreateTodoRequest;
import com.arthadede.examplemicroservice.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    @Autowired
    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody @Valid CreateTodoRequest todoPayload) {
        return new ResponseEntity<>(todoService.createTodo(todoPayload), HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodoList() {
        return new ResponseEntity<>(todoService.getTodoList(), HttpStatus.OK);
    }
}
