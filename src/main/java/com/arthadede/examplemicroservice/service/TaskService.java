package com.arthadede.examplemicroservice.service;

import com.arthadede.examplemicroservice.exception.NotFoundException;
import com.arthadede.examplemicroservice.model.Task;
import com.arthadede.examplemicroservice.model.Todo;
import com.arthadede.examplemicroservice.respository.TaskRepository;
import com.arthadede.examplemicroservice.respository.TodoRepository;
import com.arthadede.examplemicroservice.schema.CreateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TodoRepository todoRepository;

    public Task createTask(CreateTaskRequest taskPayload) {
        Todo todo = todoRepository.findById(taskPayload.getTodo_id())
                .orElseThrow(() -> new NotFoundException("todo is not found"));
        Task task = Task.builder()
                .title(taskPayload.getTitle())
                .status(taskPayload.getStatus())
                .todo(todo)
                .build();

        return taskRepository.save(task);
    }
}
