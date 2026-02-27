package com.booking.movie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
public class Payment extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private BigDecimal amount;

    private String PaymentType;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String gatewayTxnId;

}
