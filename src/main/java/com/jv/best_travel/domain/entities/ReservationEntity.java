package com.jv.best_travel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "reservation")
public class ReservationEntity {

    @Id
    private UUID id;

    @Column(name = "date_reservation")
    private LocalDateTime dateReservation;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "total_days")
    private int totalDays;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn (name = "hotel_id")
    private HotelEntity hotel;

    @ManyToOne
    @JoinColumn(name = "tour_id"
            , nullable = true) // esto se debe a que 1 reservacion puede tener un hotel o un tour, nunca los 2
    private TourEntity tour;

    @ManyToOne
    @JoinColumn(name = "customer_id"
            , nullable = true)
    private CustomerEntity customer;
}
