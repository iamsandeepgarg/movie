package com.booking.movie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Seat extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen Screen;

    private String rowLabel;

    private Integer seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_section_id")
    private TheatreSection section;

    private Integer xPosition;

    private Integer yPosition;


}
