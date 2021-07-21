package by.zadziarnouski.tms.rest.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class Bus {
    private long id;
    @NotBlank(message = "Registration plate is mandatory")
    private String registrationPlate;
    @Positive(message = "Number of passenger sets cannot be a negative number")
    private int numberOfPassengerSeats;
    @NotNull
    private Driver driver;
}
