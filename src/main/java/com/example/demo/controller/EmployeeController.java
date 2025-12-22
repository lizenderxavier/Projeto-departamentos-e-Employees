package com.example.demo.controller;

import com.example.demo.model.dto.create.EmployeeCreateDTO;
import com.example.demo.model.dto.response.EmployeeResponseDTO;
import com.example.demo.model.dto.update.EmployeeRequestDTO;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Criar funcionário
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create(@Valid @RequestBody EmployeeCreateDTO dto) {
        EmployeeResponseDTO response = employeeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Listar todos os funcionários
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAll() {
        List<EmployeeResponseDTO> employees = employeeService.getAll();
        return ResponseEntity.ok(employees);
    }

    // Buscar funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getById(@PathVariable Long id) {
        EmployeeResponseDTO employee = employeeService.getById(id);
        return ResponseEntity.ok(employee);
    }

    // Listar funcionários por departamento
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeResponseDTO>> getByDepartment(@PathVariable Long departmentId) {
        List<EmployeeResponseDTO> employees = employeeService.getByDepartment(departmentId);
        return ResponseEntity.ok(employees);
    }

    // Atualizar funcionário
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO dto) {
        EmployeeResponseDTO updatedEmployee = employeeService.update(id, dto);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Deletar funcionário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
