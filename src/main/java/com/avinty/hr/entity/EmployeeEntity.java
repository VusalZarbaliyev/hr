package com.avinty.hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "EMPLOYEES")
@Data
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "dep_id")
    private int depId;

    @ManyToOne
    @JoinColumn(name = "dep_id", nullable = false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DepartmentEntity department;

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

    @Column(name = "is_active")
    private boolean isActive;
}
