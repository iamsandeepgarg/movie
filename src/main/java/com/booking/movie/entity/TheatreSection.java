package com.booking.movie.entity;

import jakarta.persistence.*;

@Entity
public class TheatreSection extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreSectionId;

    private String displayName; //Royal,Gold,Prime,Recliner

    @Enumerated(EnumType.STRING)
    private SeatCategory seatCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="theatre_id")
    private Theatre theatre;


}
