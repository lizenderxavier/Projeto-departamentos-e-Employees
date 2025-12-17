package com.example.demo.service;

import com.example.demo.model.dto.DepartmentRequestDTO;
import com.example.demo.model.dto.DepartmentResponseDTO;
import com.example.demo.model.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentResponseDTO create(DepartmentRequestDTO dto) {
        Department department = new Department(dto.getName());
        Department saved = departmentRepository.save(department);

        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        return response;
    }

    public List<DepartmentResponseDTO> getAll() {
        return departmentRepository.findAll().stream()
                .map(dep -> {
                    DepartmentResponseDTO dto = new DepartmentResponseDTO();
                    dto.setId(dep.getId());
                    dto.setName(dep.getName());
                    return dto;
                }).collect(Collectors.toList());
    }

    public DepartmentResponseDTO update(Long id, DepartmentRequestDTO dto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));
        department.setName(dto.getName());
        Department updated = departmentRepository.save(department);

        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setId(updated.getId());
        response.setName(updated.getName());
        return response;
    }

    public void delete(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));
        departmentRepository.delete(department);
    }
}
