package com.example.demo.model.dto.response;

import com.example.demo.model.entity.enums.TaskPriority;
import com.example.demo.model.entity.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDTO {
    private Long id;
    private String title;
    private TaskStatus status;
    private TaskPriority priority;
    private Long projectId;
    private Long creatorId;
}
