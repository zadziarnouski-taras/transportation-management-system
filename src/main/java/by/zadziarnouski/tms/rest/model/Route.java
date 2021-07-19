package by.zadziarnouski.tms.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Route {
    private long id;
    private String source;
    private String destination;
    private LocalDateTime timeOfDeparture;
    private LocalDateTime timeOfArrival;
    private Bus bus;
}
