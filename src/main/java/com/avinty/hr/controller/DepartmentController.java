package com.avinty.hr.controller;

import com.avinty.hr.entity.DepartmentEntity;
import com.avinty.hr.model.DepartmentDTO;
import com.avinty.hr.model.ResponseDTO;
import com.avinty.hr.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/API/V1")
@Slf4j
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/dep-emp")
    public ResponseEntity<ResponseDTO> getDepartments() {
        log.info("Request received for getting departments");
        List<DepartmentEntity> departments = service.getAllDepartments();
        List<DepartmentDTO> departmentDTOList = departments.stream().map(entity->DepartmentDTO.from(entity)).collect(Collectors.toList());
        return new ResponseEntity<>(ResponseDTO.data(departmentDTOList), HttpStatus.OK);
    }

    @GetMapping("/department")
    public ResponseEntity<ResponseDTO> departmentByName(@RequestParam String name) throws Exception {
        log.info("Request received for getting departments by name");
        List<DepartmentEntity> departments = service.departmentByName(name);
        List<DepartmentDTO> departmentDTOList = departments.stream().map(entity->DepartmentDTO.from(entity)).collect(Collectors.toList());
        return new ResponseEntity<>(ResponseDTO.data(departmentDTOList), HttpStatus.OK);
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception {
        log.info("Request received for deleting departments by name");
        DepartmentEntity departmentEntity = service.delete(id);
        return new ResponseEntity<>(ResponseDTO.data(DepartmentDTO.from(departmentEntity)), HttpStatus.OK);
    }
}
