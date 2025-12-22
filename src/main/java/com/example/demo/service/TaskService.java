package com.example.demo.service;

import com.example.demo.model.dto.create.TaskCreateDTO;
import com.example.demo.model.dto.response.TaskResponseDTO;
import com.example.demo.model.entity.Employee;
import com.example.demo.model.entity.Project;
import com.example.demo.model.entity.Task;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    public TaskResponseDTO create(TaskCreateDTO dto) {
        Project project = projectRepository.findById(dto.getProjectId()).orElseThrow();
        Employee creator = employeeRepository.findById(dto.getCreatorId()).orElseThrow();

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setProject(project);
        task.setCreator(creator);

        taskRepository.save(task);
        return toDTO(task);
    }

    public List<TaskResponseDTO> getByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    private TaskResponseDTO toDTO(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        dto.setProjectId(task.getProject().getId());
        dto.setCreatorId(task.getCreator().getId());
        return dto;
    }
}
