package com.collabor8.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "code_documents")
public class CodeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 50)
    private String language;

    @Column(name = "created_at", nullable = false, updatable = false)
    private final OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private final OffsetDateTime updatedAt = OffsetDateTime.now();

    // Relationships
    @OneToOne
    @JoinColumn(name = "room_id", nullable = false, unique = true)
    private Room room;

    // Getters and setters omitted for brevity
}
