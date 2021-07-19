package by.zadziarnouski.tms.rest.viewModel;

import lombok.*;

@Getter
@Setter
@ToString
public class Bus {
    private String registrationPlate;
    private int numberOfPassengerSeats;
    private String driver;
}
