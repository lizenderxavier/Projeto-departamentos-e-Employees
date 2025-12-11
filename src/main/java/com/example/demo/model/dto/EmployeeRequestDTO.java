package com.example.demo.model.dto;

public record EmployeeRequestDTO(
        String name,
        Double salary,
        String position, // adicionamos position
        Long departmentId
) {}
