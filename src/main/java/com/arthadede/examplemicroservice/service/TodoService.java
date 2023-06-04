package com.arthadede.examplemicroservice.service;

import com.arthadede.examplemicroservice.model.Image;
import com.arthadede.examplemicroservice.model.Todo;
import com.arthadede.examplemicroservice.respository.ImageRepository;
import com.arthadede.examplemicroservice.respository.TodoRepository;
import com.arthadede.examplemicroservice.schema.CreateTodoRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ImageRepository imageRepository;

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Transactional
    public Todo createTodo(CreateTodoRequest payload) {
        Todo todo = Todo.builder()
                .title(payload.getTitle())
                .color(payload.getColor())
                .build();
        Image image = Image.builder()
                .uri(payload.getImageUri())
                .build();
        Image imageResponse = imageRepository.save(image);
        todo.setImage(imageResponse);

        return todoRepository.save(todo);
    }
}
