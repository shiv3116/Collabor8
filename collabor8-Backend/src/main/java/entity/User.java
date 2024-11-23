package entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 32)
    private String user_name;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false, length = 128)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime created_at = OffsetDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updated_at = OffsetDateTime.now();

    @OneToMany(mappedBy = "owner")
    private List<Room> roomsOwned;

    @ManyToMany(mappedBy = "participants")
    private List<Room> roomsParticipatedIn;

}