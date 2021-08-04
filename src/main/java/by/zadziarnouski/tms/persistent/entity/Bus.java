package by.zadziarnouski.tms.persistent.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "buses")
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationPlate;
    private int numberOfPassengerSeats;

    @OneToOne(cascade = CascadeType.ALL)
    private Driver driver;
}
