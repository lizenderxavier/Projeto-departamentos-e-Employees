package com.example.demo.service;

import com.example.demo.model.dto.EmployeeRequestDTO;
import com.example.demo.model.dto.EmployeeResponseDTO;
import com.example.demo.model.entity.Department;
import com.example.demo.model.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    // CRIAR EMPLOYEE
    public EmployeeResponseDTO create(EmployeeRequestDTO dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));

        Employee employee = new Employee(dto.getName(), dto.getEmail(), dto.getRole(), department);
        Employee saved = employeeRepository.save(employee);

        return toDTO(saved);
    }

    // LISTAR TODOS OS EMPLOYEES
    public List<EmployeeResponseDTO> getAll() {
        return employeeRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // LISTAR EMPLOYEES POR DEPARTAMENTO
    public List<EmployeeResponseDTO> getByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ATUALIZAR EMPLOYEE
    public EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee não encontrado"));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado"));

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setRole(dto.getRole());
        employee.setDepartment(department);

        Employee updated = employeeRepository.save(employee);
        return toDTO(updated);
    }

    // DELETAR EMPLOYEE
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee não encontrado"));
        employeeRepository.delete(employee);
    }

    // MÉTODO AUXILIAR PARA CONVERSÃO ENTITY → DTO
    private EmployeeResponseDTO toDTO(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setRole(employee.getRole());
        dto.setDepartmentName(employee.getDepartment().getName());
        return dto;
    }
}
