package com.arthadede.examplemicroservice.controller;

import com.arthadede.examplemicroservice.connector.GithubConnector;
import com.arthadede.examplemicroservice.model.Todo;
import com.arthadede.examplemicroservice.schema.CreateTodoRequest;
import com.arthadede.examplemicroservice.schema.GithubAccount;
import com.arthadede.examplemicroservice.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final GithubConnector githubConnector;

    @GetMapping("/profile")
    public ResponseEntity<GithubAccount> getProfile() {
        return new ResponseEntity<>(githubConnector.getProfile(), HttpStatus.OK);
    }
}
