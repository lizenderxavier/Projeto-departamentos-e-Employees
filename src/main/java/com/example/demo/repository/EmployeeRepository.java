package com.example.demo.repository;

import com.example.demo.model.entity.Department;
import com.example.demo.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Busca lista de funcionários filtrando pelo objeto departamento
    List<Employee> findByDepartment(Department department);
}