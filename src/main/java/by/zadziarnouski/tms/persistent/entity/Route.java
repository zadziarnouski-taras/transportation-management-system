package by.zadziarnouski.tms.persistent.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "routes")
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String destination;
    private LocalDateTime timeOfDeparture;
    private LocalDateTime timeOfArrival;
    @OneToOne()
    private Bus bus;

    @ManyToOne()
    private Station station;
}
