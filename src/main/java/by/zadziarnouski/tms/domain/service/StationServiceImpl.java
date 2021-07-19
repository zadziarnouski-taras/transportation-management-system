package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Station;
import by.zadziarnouski.tms.mapper.StationMapper;
import by.zadziarnouski.tms.persistent.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    @Autowired
    public StationServiceImpl(StationRepository stationRepository, StationMapper stationMapper) {
        this.stationRepository = stationRepository;
        this.stationMapper = stationMapper;
    }

    @Override
    public Station saveOrUpdate(Station station) {
        return stationMapper.entityToDomain(stationRepository.save(stationMapper.domainToEntity(station)));
    }

    @Override
    public Station findById(Long id) {
        return stationMapper.entityToDomain(stationRepository.findById(id).get());
    }

    @Override
    public Station findByLocation(String location) {
        return stationMapper.entityToDomain(stationRepository.findByLocation(location));
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll().stream().map(stationMapper::entityToDomain).collect(toList());
    }

    @Override
    public void delete(long id) {

    }
}
