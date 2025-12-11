package com.example.demo.model.dto;

public record EmployeeResponseDTO(
        Long id,
        String name,
        Double salary,
        String position, // adicionamos position
        String departmentName
) {}
