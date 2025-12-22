package com.example.demo.controller;

import com.example.demo.model.dto.create.TaskCreateDTO;
import com.example.demo.model.dto.response.TaskResponseDTO;
import com.example.demo.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public TaskResponseDTO create(@Valid @RequestBody TaskCreateDTO dto) {
        return taskService.create(dto);
    }

    @GetMapping("/project/{projectId}")
    public List<TaskResponseDTO> getByProject(@PathVariable Long projectId) {
        return taskService.getByProject(projectId);
    }
}
