package by.zadziarnouski.tms.rest.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
public class Station {
    private long id;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Location is mandatory")
    private String location;
    @Positive(message = "Platform number cannot be negative")
    private int numberOfPlatforms;
    List<Route> routes;
}
