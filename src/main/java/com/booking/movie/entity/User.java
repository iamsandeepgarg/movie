package com.booking.movie.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Getter @Setter
public class User extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String mobile;

    private String passwordHash;

    private LocalDateTime createdAt = LocalDateTime.now();

}
