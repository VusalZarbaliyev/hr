package com.avinty.hr.services.impl;

import com.avinty.hr.entity.EmployeeEntity;
import com.avinty.hr.repository.EmployeeRepository;
import com.avinty.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity insert(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }
}
