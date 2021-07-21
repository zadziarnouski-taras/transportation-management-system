package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Driver;
import by.zadziarnouski.tms.mapper.DriverMapper;
import by.zadziarnouski.tms.persistent.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @Override
    public Driver saveOrUpdate(Driver driver) {
        return driverMapper.entityToDomain(driverRepository.save(driverMapper.domainToEntity(driver)));
    }

    @Override
    public Driver findById(Long id) {
        return driverMapper.entityToDomain(driverRepository.findById(id).get());
    }

    @Override
    public Driver findDriverByFirstAndLastName(String firstName, String lastName) {
        return driverMapper.entityToDomain(driverRepository.findDriverByFirstNameAndLastName(firstName, lastName));
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll().stream().map(driverMapper::entityToDomain).collect(toList());
    }

    @Override
    public void delete(long id) {
        driverRepository.deleteById(id);
    }
}
