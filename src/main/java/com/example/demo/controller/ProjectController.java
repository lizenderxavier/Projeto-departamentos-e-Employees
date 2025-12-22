package com.example.demo.controller;

import com.example.demo.model.dto.create.ProjectCreateDTO;
import com.example.demo.model.dto.response.ProjectResponseDTO;
import com.example.demo.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ProjectResponseDTO create(@Valid @RequestBody ProjectCreateDTO dto) {
        return projectService.create(dto);
    }

    @GetMapping
    public List<ProjectResponseDTO> getAll() {
        return projectService.getAll();
    }
}
