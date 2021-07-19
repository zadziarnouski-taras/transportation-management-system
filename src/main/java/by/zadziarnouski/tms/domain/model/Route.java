package by.zadziarnouski.tms.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class Route {
    private String source;
    private String destination;
    private LocalDateTime timeOfDeparture;
    private LocalDateTime timeOfArrival;
    private Bus bus;
}
