package by.zadziarnouski.tms.mapper;

import by.zadziarnouski.tms.domain.model.Bus;
import by.zadziarnouski.tms.domain.model.Driver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public DriverMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Driver toDomain(by.zadziarnouski.tms.persistent.entity.Driver driver) {
        return modelMapper.map(driver, Driver.class);
    }

    public by.zadziarnouski.tms.persistent.entity.Driver ToEntity(Driver driver) {
        return modelMapper.map(driver, by.zadziarnouski.tms.persistent.entity.Driver.class);
    }
}
