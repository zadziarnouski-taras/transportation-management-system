package by.zadziarnouski.tms.domain.service;

import by.zadziarnouski.tms.domain.model.Driver;
import by.zadziarnouski.tms.exception.SystemException;
import by.zadziarnouski.tms.exception.ValidationCode;
import by.zadziarnouski.tms.mapper.DriverMapper;
import by.zadziarnouski.tms.persistent.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Override
    public Driver saveOrUpdate(Driver driver) {
        return driverMapper.entityToDomain(driverRepository.save(driverMapper.domainToEntity(driver)));
    }

//    @Override
//    public Driver findById(Long id) {
//        return driverMapper.entityToDomain(driverRepository.findById(id).get());
//    }

    @Override
    public Driver findById(Long id) {
        Optional<by.zadziarnouski.tms.persistent.entity.Driver> byId = driverRepository.findById(id);
        if (byId.isPresent()) {
            return driverMapper.entityToDomain(byId.get());
        } else {
            log.warn("Driver with such " + id + " doesn't exist!!!");
            throw new SystemException(ValidationCode.INCORRECT_DATA_ENTRY);
            //TODO исправить это место
        }
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
