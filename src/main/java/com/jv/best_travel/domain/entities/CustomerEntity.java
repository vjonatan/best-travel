package com.jv.best_travel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "customer")
public class CustomerEntity {

    @Id
    private String dni;

    private String fullName;
    private String creditCard;
    private int totalFlights;
    private int totalLodgings;
    private int totalTours;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL
            , fetch = FetchType.EAGER
            , orphanRemoval = true
            , mappedBy = "customer")
    private List<TicketEntity> tickets;

    @OneToMany(cascade = CascadeType.ALL
            , fetch = FetchType.EAGER
            , orphanRemoval = true
            , mappedBy = "customer")
    private List<TourEntity> tours;

    @OneToMany(cascade = CascadeType.ALL
            , fetch = FetchType.EAGER
            , orphanRemoval = true
            , mappedBy = "customer")
    private List<ReservationEntity> reservations;
}
