package by.zadziarnouski.tms.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Station {
    private long id;
    private String address;
    private String location;
    private int numberOfPlatforms;
    List<Route> routes;
}
