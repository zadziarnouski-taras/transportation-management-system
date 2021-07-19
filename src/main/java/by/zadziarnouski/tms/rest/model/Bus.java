package by.zadziarnouski.tms.rest.model;

import lombok.*;

@Getter
@Setter
@ToString
public class Bus {
    private long id;
    private String registrationPlate;
    private int numberOfPassengerSeats;
    private Driver driver;
}
