package com.avinty.hr.model;

import com.avinty.hr.entity.DepartmentEntity;
import com.avinty.hr.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentDTO {

    private long id;
    private List<EmployeeEntity> employees;

    public static DepartmentDTO from(DepartmentEntity departmentEntity){
        return new DepartmentDTO(departmentEntity.getId(),departmentEntity.getEmployees());
    }

}
