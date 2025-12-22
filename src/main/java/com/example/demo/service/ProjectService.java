package com.example.demo.service;

import com.example.demo.model.dto.create.ProjectCreateDTO;
import com.example.demo.model.dto.response.ProjectResponseDTO;
import com.example.demo.model.entity.Employee;
import com.example.demo.model.entity.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    public ProjectResponseDTO create(ProjectCreateDTO dto) {
        Employee manager = employeeRepository.findById(dto.getManagerId()).orElseThrow();

        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setManager(manager);

        projectRepository.save(project);
        return toDTO(project);
    }

    public List<ProjectResponseDTO> getAll() {
        return projectRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ProjectResponseDTO toDTO(Project project) {
        ProjectResponseDTO dto = new ProjectResponseDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setStatus(project.getStatus());
        dto.setManagerId(project.getManager().getId());
        return dto;
    }
}
