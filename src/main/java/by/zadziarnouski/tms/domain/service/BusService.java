package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Bus;

public interface BusService {
    Bus findByRegistrationPlate(String registrationPlate);
}
