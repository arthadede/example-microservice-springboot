package com.arthadede.examplemicroservice.schema;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTodoRequest {
    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "color is required")
    private String color;

    @NotNull(message = "imageUri is required")
    private String imageUri;
}
