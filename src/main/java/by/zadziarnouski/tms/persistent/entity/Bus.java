package by.zadziarnouski.tms.persistent.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationPlate;
    private int numberOfPassengerSeats;

    @OneToOne
    private Driver driver;
}
