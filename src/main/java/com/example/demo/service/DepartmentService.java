package com.example.demo.service;

import com.example.demo.model.dto.create.DepartmentCreateDTO;
import com.example.demo.model.dto.update.DepartmentRequestDTO;
import com.example.demo.model.dto.response.DepartmentDetailDTO;
import com.example.demo.model.dto.response.DepartmentListDTO;
import com.example.demo.model.dto.response.DepartmentResponseDTO;
import com.example.demo.model.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentResponseDTO create(DepartmentCreateDTO dto) {
        Department department = new Department(
                dto.getName(),
                dto.getDescription()
        );

        Department saved = departmentRepository.save(department);

        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());

        return response;
    }

    public List<DepartmentListDTO> getAll() {
        return departmentRepository.findAll()
                .stream()
                .map(dep -> {
                    DepartmentListDTO dto = new DepartmentListDTO();
                    dto.setId(dep.getId());
                    dto.setName(dep.getName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public DepartmentDetailDTO getById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Departamento não encontrado"
                        )
                );

        DepartmentDetailDTO dto = new DepartmentDetailDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());

        return dto;
    }

    public DepartmentResponseDTO update(Long id, DepartmentRequestDTO dto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Departamento não encontrado"
                        )
                );

        department.setName(dto.getName());
        department.setDescription(dto.getDescription());

        Department updated = departmentRepository.save(department);

        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setId(updated.getId());
        response.setName(updated.getName());
        response.setDescription(updated.getDescription());

        return response;
    }

    public void delete(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Departamento não encontrado"
                        )
                );

        departmentRepository.delete(department);
    }
}
