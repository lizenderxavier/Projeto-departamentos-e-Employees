package com.example.demo.service;

import com.example.demo.model.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Listar departamentos
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    // Buscar por ID
    public Department findDepartmentById(Long id) {
        Optional<Department> dept = departmentRepository.findById(id);
        return dept.orElse(null); // se não encontrar, retorna null
    }

    // Criar novo departamento
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Atualizar departamento
    public Department updateDepartment(Long id, Department department) {
        Department existing = findDepartmentById(id);
        if (existing != null) {
            existing.setName(department.getName());
            existing.setDescription(department.getDescription());
            return departmentRepository.save(existing);
        }
        return null;
    }

    // Deletar departamento
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
