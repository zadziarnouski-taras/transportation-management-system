package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Route;

import java.util.List;

public interface RouteService {
    Route saveOrUpdate(Route route);
    Route findById(Long id);
    Route findBySource(String source);
    Route findByDestination(String destination);
    Route findBySourceAndDestination(String source, String destination);
    List<Route> findAll();
    void delete(long id);
}
