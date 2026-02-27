package com.booking.movie.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "screen")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screen extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer seatingCapacity;

    private String screenType; // IMAX, 2D, 3D

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;


}
