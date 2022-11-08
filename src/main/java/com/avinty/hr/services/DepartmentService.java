package com.avinty.hr.services;

import com.avinty.hr.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> getAllDepartments();
    DepartmentEntity delete(Integer id) throws Exception;
    List<DepartmentEntity> departmentByName(String name) throws Exception;
}
