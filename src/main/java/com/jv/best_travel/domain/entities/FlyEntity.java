package com.jv.best_travel.domain.entities;

import com.jv.best_travel.util.AeroLine;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity(name = "fly")
public class FlyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private Double destinyLng;

    @Column(length = 20)
    private String originName;
    @Column(length = 20)
    private String destinyName;

    @Enumerated(EnumType.STRING)
    private AeroLine aeroLine;

    private Double price;

    @OneToMany(mappedBy = "fly"
        , cascade = CascadeType.ALL   //CascadeType.ALL -> si se elimina el Fly, se elimina los tickets vinculados
        , fetch = FetchType.EAGER
        , orphanRemoval = true)       //orphanRemoval -> si el objeto se queda sin su llave foranea, lo remueve
    private List<TicketEntity> tickets;
}
