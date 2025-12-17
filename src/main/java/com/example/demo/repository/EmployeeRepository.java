package com.example.demo.repository;

import com.example.demo.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // LISTAR EMPLOYEES POR DEPARTAMENTO
    List<Employee> findByDepartmentId(Long departmentId);

}
