package com.avinty.hr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DEPARTMENTS")
@Data
public class DepartmentEntity implements Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private String managerId;

    @OneToMany(targetEntity=EmployeeEntity.class, mappedBy="depId", fetch = FetchType.LAZY)
    List<EmployeeEntity> employees;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "updated_at", nullable = false, updatable = false)
    private LocalDateTime updateAt;

    @Column(name = "updated_by", updatable = false)
    private String updatedBy;
}
