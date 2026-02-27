package com.booking.movie.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movies")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Movie extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String language;

    private String genre;

    @Column(nullable = false)
    private Integer durationMinutes;

    private String certificate; // U, UA, A

    private Boolean active = true;
}
