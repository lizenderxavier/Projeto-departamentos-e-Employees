package com.example.demo.model.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequestDTO {
    private Long id;

    @NotBlank
    @Size(min = 3, max = 150)
    private String name;

    @NotBlank
    @Size(min = 10, max = 250)
    private String description;
}

// Getters e Setters
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }


