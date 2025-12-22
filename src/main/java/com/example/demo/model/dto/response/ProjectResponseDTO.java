package com.example.demo.model.dto.response;

import com.example.demo.model.entity.enums.ProjectStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponseDTO {
    private Long id;
    private String name;
    private String description;
    private ProjectStatus status;
    private Long managerId;
}
