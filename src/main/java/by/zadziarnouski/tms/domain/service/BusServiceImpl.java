package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Bus;
import by.zadziarnouski.tms.mapper.BusMapper;
import by.zadziarnouski.tms.persistent.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {
    private final BusRepository busRepository;
    private final BusMapper busMapper;

    @Override
    public Bus saveOrUpdate(Bus bus) {
        return busMapper.entityToDomain(busRepository.save(busMapper.domainToEntity(bus)));
    }

    @Override
    public Bus findById(Long id) {
        return busMapper.entityToDomain(busRepository.findById(id).get());
    }

    @Override
    public Bus findByRegistrationPlate(String registrationPlate) {
        return busMapper.entityToDomain(busRepository.findByRegistrationPlate(registrationPlate));
    }

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll().stream().map(busMapper::entityToDomain).collect(toList());
    }

    @Override
    public void delete(long id) {
        busRepository.deleteById(id);
    }
}