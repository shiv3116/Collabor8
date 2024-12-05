package com.collabor8.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 32)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false, length = 128)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private final OffsetDateTime created_at = OffsetDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private final OffsetDateTime updated_at = OffsetDateTime.now();

    @OneToMany(mappedBy = "owner")
    private List<Room> roomsOwned;

    @ManyToMany(mappedBy = "participants")
    private List<Room> roomsParticipatedIn;

}