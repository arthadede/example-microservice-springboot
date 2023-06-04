package com.arthadede.examplemicroservice.controller;

import com.arthadede.examplemicroservice.model.Task;
import com.arthadede.examplemicroservice.schema.CreateTaskRequest;
import com.arthadede.examplemicroservice.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody @Valid CreateTaskRequest taskPayload) {
        return new ResponseEntity<>(taskService.createTask(taskPayload), HttpStatus.CREATED);
    }
}
