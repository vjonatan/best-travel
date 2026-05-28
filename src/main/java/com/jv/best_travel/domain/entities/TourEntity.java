package com.jv.best_travel.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "tour")
public class TourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL
        , fetch = FetchType.EAGER
        , orphanRemoval = true
        , mappedBy = "tour")
    private List<ReservationEntity> reservations;

    @OneToMany(cascade = CascadeType.ALL
        , fetch = FetchType.EAGER
        , orphanRemoval = true
        , mappedBy = "tour")
    private List<TicketEntity> tickets;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customer;
}
