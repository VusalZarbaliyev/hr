package com.avinty.hr.services.impl;

import com.avinty.hr.entity.DepartmentEntity;
import com.avinty.hr.entity.EmployeeEntity;
import com.avinty.hr.repository.DepartmentRepository;
import com.avinty.hr.repository.EmployeeRepository;
import com.avinty.hr.services.DepartmentService;
import com.avinty.hr.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        log.info("Fetching all departments data from db");
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity delete(Integer id) throws Exception {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        if (!departmentEntity.isPresent()){
            throw new Exception("Department not found");
        }
        log.info("Setting null value for departments of employees");
        departmentEntity.get().getEmployees().stream().forEach(employeeEntity -> {
            employeeEntity.setDepId(null);
            employeeRepository.save(employeeEntity);
        });
        log.info("Deleting department from db");
        departmentRepository.deleteById(id);
        return departmentEntity.get();
    }

    @Override
    public List<DepartmentEntity> departmentByName(String name) throws Exception {
        Optional<List<DepartmentEntity>> departments = departmentRepository.findByName(name);
        if (!departments.isPresent() || departments.get().size()==0){
            throw new Exception("Department not found");
        }
        return departments.get();
    }
}
