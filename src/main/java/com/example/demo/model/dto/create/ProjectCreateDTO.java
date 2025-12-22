package com.example.demo.model.dto.create;

import com.example.demo.model.entity.enums.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectCreateDTO {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private ProjectStatus status;

    @NotNull
    private Long managerId;
}
