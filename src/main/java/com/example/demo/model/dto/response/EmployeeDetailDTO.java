package com.example.demo.model.dto.response;

import com.example.demo.model.entity.enums.JobRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDetailDTO {
    private Long id;
    private String name;
    private String email;
    private JobRole role;
    private String departmentName;
}