package com.avinty.hr.repository;

import com.avinty.hr.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    Optional<EmployeeEntity> findByEmail(String email);
}
