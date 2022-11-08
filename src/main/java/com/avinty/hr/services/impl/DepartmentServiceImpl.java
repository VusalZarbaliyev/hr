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
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity delete(Integer id) throws Exception {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        if (!departmentEntity.isPresent()){
            throw new Exception("Department not found");
        }
        departmentEntity.get().getEmployees().stream().forEach(employeeEntity -> {
            employeeEntity.setDepId(null);
            employeeRepository.save(employeeEntity);
        });
        departmentRepository.deleteById(id);
        return departmentEntity.get();
    }
}
