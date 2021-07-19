package by.zadziarnouski.tms.rest.viewModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Station {
    private String address;
    private String location;
    private int numberOfPlatforms;
    List<Route> routes;
}
