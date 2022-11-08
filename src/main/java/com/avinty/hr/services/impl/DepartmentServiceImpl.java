package com.avinty.hr.services.impl;

import com.avinty.hr.entity.DepartmentEntity;
import com.avinty.hr.entity.EmployeeEntity;
import com.avinty.hr.repository.DepartmentRepository;
import com.avinty.hr.repository.EmployeeRepository;
import com.avinty.hr.services.DepartmentService;
import com.avinty.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
