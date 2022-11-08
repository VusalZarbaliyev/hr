package com.avinty.hr.services;

import com.avinty.hr.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity insert(EmployeeEntity employeeEntity) throws Exception;
}
