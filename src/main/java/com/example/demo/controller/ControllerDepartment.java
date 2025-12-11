package com.example.demo.controller;

import com.example.demo.model.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class ControllerDepartment {

    @Autowired
    private DepartmentService departmentService;

    // LISTAR TODOS
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return departmentService.findDepartmentById(id);
    }

    // CRIAR
    @PostMapping
    public Department create(@RequestBody Department dept) {
        return departmentService.createDepartment(dept);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department dept) {
        return departmentService.updateDepartment(id, dept);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
