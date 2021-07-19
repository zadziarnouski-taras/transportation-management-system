package by.zadziarnouski.tms.rest.viewModel;

import lombok.Getter;
import lombok.Setter;

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
