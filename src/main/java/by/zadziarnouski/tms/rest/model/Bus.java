package by.zadziarnouski.tms.rest.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Bus {
    private long id;
    @NotBlank(message = "Registration plate is mandatory")
    private String registrationPlate;
    @Min(value = 1, message = "Bus has 1 or more seats for passengers")
    @Max(value = 110, message = "Bus cannot have more than 110 seats for passengers")
    private int numberOfPassengerSeats;
    @NotNull
    private Driver driver;
}
