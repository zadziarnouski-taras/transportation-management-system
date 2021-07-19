package by.zadziarnouski.tms.domain.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class Station {
    private Long id;
    private String address;
    private String location;
    private int numberOfPlatforms;
    List<Route> routes;
}
