package com.jv.best_travel.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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


}
