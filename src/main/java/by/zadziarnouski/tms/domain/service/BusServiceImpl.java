package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Bus;
import by.zadziarnouski.tms.mapper.BusMapper;
import by.zadziarnouski.tms.persistent.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {
    private final BusRepository busRepository;
    private final BusMapper busMapper;

    @Autowired
    public BusServiceImpl(BusRepository busRepository, BusMapper busMapper) {
        this.busRepository = busRepository;
        this.busMapper = busMapper;
    }

    @Override
    public Bus findByRegistrationPlate(String registrationPlate) {
        return busMapper.entityToDomain(busRepository.findByRegistrationPlate(registrationPlate));
    }
}