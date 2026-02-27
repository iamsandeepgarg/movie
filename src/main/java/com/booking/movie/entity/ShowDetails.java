package com.booking.movie.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "show_details")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowDetails extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long showId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    private LocalDate showDate;

    private LocalTime showTime;

    private Boolean isActive = true;

}
