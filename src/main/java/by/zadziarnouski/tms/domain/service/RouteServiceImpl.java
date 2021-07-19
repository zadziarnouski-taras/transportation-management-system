package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Route;
import by.zadziarnouski.tms.mapper.RouteMapper;
import by.zadziarnouski.tms.persistent.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    @Override
    public Route saveOrUpdate(Route route) {
        return routeMapper.entityToDomain(routeRepository.save(routeMapper.domainToEntity(route)));
    }

    @Override
    public Route findById(Long id) {
        return routeMapper.entityToDomain(routeRepository.findById(id).get());
    }

    @Override
    public Route findBySource(String source) {
        return routeMapper.entityToDomain(routeRepository.findBySource(source));
    }

    @Override
    public Route findByDestination(String destination) {
        return routeMapper.entityToDomain(routeRepository.findByDestination(destination));
    }

    @Override
    public Route findBySourceAndDestination(String source, String destination) {
        return routeMapper.entityToDomain(routeRepository.findBySourceAndDestination(source, destination));
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll().stream().map(routeMapper::entityToDomain).collect(toList());
    }

    @Override
    public void delete(long id) {
        routeRepository.deleteById(id);
    }
}
