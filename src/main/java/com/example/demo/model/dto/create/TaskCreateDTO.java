package com.example.demo.model.dto.create;

import com.example.demo.model.entity.enums.TaskPriority;
import com.example.demo.model.entity.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateDTO {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private TaskStatus status;

    @NotNull
    private TaskPriority priority;

    @NotNull
    private Long projectId;

    @NotNull
    private Long creatorId;
}
