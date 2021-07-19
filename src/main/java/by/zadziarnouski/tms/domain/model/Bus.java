package by.zadziarnouski.tms.domain.model;

import lombok.*;

@Getter
@Setter
public class Bus {
    private String registrationPlate;
    private int numberOfPassengerSeats;
    private Driver driver;
}
