package com.booking.movie.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.boot.model.internal.BinderHelper;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingSeat extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingSeatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_seat_id")
    private ShowSeat showSeat;

    private BigDecimal price;

}
