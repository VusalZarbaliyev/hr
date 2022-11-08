package com.avinty.hr.services.impl;

import com.avinty.hr.entity.EmployeeEntity;
import com.avinty.hr.repository.EmployeeRepository;
import com.avinty.hr.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        log.info("Fetching all employees data from db");
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity insert(EmployeeEntity employeeEntity) throws Exception {
        if (employeeRepository.findByEmail(employeeEntity.getEmail()).isPresent()){
            throw new Exception("This email has already been taken");
        }
        log.info("Inserting a new employee data into db");
        String encodedPass = passwordEncoder.encode(employeeEntity.getPassword());
        employeeEntity.setPassword(encodedPass);
        return employeeRepository.save(employeeEntity);
    }
}
