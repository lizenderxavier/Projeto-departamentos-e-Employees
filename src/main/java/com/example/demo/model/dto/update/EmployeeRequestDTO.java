package com.example.demo.model.dto.update;

import com.example.demo.model.entity.enums.JobRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private JobRole role;

    @NotNull
    private Long departmentId;
}
