package com.example.demo.model.dto;

import com.example.demo.model.entity.JobRole;

public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private JobRole role;
    private String departmentName;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public JobRole getRole() { return role; }
    public void setRole(JobRole role) { this.role = role; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
}
