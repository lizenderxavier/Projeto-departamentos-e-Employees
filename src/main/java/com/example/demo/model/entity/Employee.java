package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double salary;
    private String position; // novo campo

    // muitos empregados para 1 departamento
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // construtor vazio (obrigatório para JPA)
    public Employee() {}

    // construtor completo
    public Employee(String name, Double salary, String position, Department department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    // getters e setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
