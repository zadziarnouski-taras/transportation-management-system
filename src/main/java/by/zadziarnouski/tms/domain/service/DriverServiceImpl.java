package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Driver;
import by.zadziarnouski.tms.mapper.DriverMapper;
import by.zadziarnouski.tms.persistent.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
    private DriverRepository driverRepository;
    private DriverMapper driverMapper;

    @Autowired
    public void setDriverRepository(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Autowired
    public void setDriverMapper(DriverMapper driverMapper) {
        this.driverMapper = driverMapper;
    }

    @Override
    public Driver getDriverByFirstAndLastName(String firstName, String lastName) {
        return driverMapper.toDomain(driverRepository.findDriverByFirstNameAndLastName(firstName, lastName));
    }
}
