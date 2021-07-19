package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Driver;
import org.springframework.stereotype.Service;

public interface DriverService {
    Driver getDriverByFirstAndLastName(String firstName, String lastName);
}
