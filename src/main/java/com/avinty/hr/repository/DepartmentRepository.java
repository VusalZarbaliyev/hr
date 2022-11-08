package com.avinty.hr.repository;

import com.avinty.hr.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
    Optional<List<DepartmentEntity>> findByName(String name);
}
