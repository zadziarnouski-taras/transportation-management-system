package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Station;

import java.util.List;

public interface StationService {
    Station saveOrUpdate(Station station);
    Station findById(Long id);
    Station findByLocation(String location);
    List<Station> findAll();
    void delete(long id);
}
