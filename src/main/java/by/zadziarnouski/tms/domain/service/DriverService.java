package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Driver;

import java.util.List;

public interface DriverService {
    Driver saveOrUpdate(Driver Driver);
    Driver findById(Long id);
    Driver findDriverByFirstAndLastName(String firstName, String lastName);
    List<Driver> findAll();
    void delete(long id);
}
