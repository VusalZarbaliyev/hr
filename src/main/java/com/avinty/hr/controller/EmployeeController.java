package com.avinty.hr.controller;

import com.avinty.hr.entity.EmployeeEntity;
import com.avinty.hr.model.ResponseDTO;
import com.avinty.hr.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/V1/employees")
public class EmployeeController{

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getEmployees() {
        return new ResponseEntity<>(ResponseDTO.data(service.getAllEmployees()), HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> createEmployee(@RequestBody EmployeeEntity employeeEntity) throws Exception {
        EmployeeEntity employee = service.insert(employeeEntity);
        return new ResponseEntity<>(ResponseDTO.data(employee), HttpStatus.OK);
    }
}
