package com.arthadede.examplemicroservice.schema;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTaskRequest {
    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "status is required")
    private String status;

    @NotNull(message = "todo_id is required")
    private Long todo_id;
}
