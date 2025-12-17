package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private JobRole role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Construtor vazio
    public Employee() {}

    // Construtor completo
    public Employee(String name, String email, JobRole role, Department department) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.department = department;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public JobRole getRole() { return role; }
    public void setRole(JobRole role) { this.role = role; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
