package by.zadziarnouski.tms.rest.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
public class Station {
    private long id;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Location is mandatory")
    private String location;
    @Positive
    private int numberOfPlatforms;
    List<Route> routes;
}
