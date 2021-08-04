package by.zadziarnouski.tms.rest.model;

import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class Route {
    private long id;
    @NotBlank(message = "Source is mandatory")
    private String source;
    @NotBlank(message = "Destination is mandatory")
    private String destination;
    @FutureOrPresent
    private LocalDateTime timeOfDeparture;
    @FutureOrPresent
    private LocalDateTime timeOfArrival;
    @NotNull
    private Bus bus;
}
