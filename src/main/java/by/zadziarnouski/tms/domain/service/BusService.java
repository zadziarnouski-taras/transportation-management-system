package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Bus;

import java.util.List;

public interface BusService {
    Bus saveOrUpdate(Bus bus);
    Bus findById(Long id);
    Bus findByRegistrationPlate(String registrationPlate);
    List<Bus> findAll();
    void delete(long id);
}
