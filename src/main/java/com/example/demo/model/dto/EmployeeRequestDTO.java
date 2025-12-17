package com.example.demo.model.dto;

import com.example.demo.model.entity.JobRole;

public class EmployeeRequestDTO {

    private String name;
    private String email;
    private JobRole role;
    private Long departmentId;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public JobRole getRole() { return role; }
    public void setRole(JobRole role) { this.role = role; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
}
