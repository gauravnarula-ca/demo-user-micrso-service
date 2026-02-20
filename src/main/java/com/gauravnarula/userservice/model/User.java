package com.gauravnarula.userservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "users", // note - can be read from  env or config
        uniqueConstraints = {@UniqueConstraint(name = "unique_email",columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String password; // user password encoder - spring security
    private Date dob;

    @Column(name = "created_at", updatable = false, insertable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", updatable = true, insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", updatable = false, insertable = false)
    private LocalDateTime deletedAt;

}
