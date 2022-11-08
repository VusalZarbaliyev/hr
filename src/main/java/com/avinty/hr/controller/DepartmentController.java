package com.avinty.hr.controller;

import com.avinty.hr.entity.DepartmentEntity;
import com.avinty.hr.model.DepartmentDTO;
import com.avinty.hr.model.ResponseDTO;
import com.avinty.hr.services.DepartmentService;
import liquibase.pro.packaged.R;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/API/V1")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/dep-emp")
    public ResponseEntity<ResponseDTO> getDepartments() {
        List<DepartmentEntity> departments = service.getAllDepartments();
        List<DepartmentDTO> departmentDTOList = departments.stream().map(entity->DepartmentDTO.from(entity)).collect(Collectors.toList());
        return new ResponseEntity<>(ResponseDTO.data(departmentDTOList), HttpStatus.OK);
    }
}