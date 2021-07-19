package by.zadziarnouski.tms.mapper;

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

    public Driver entityToDomain(by.zadziarnouski.tms.persistent.entity.Driver driver) {
        return modelMapper.map(driver, Driver.class);
    }

    public by.zadziarnouski.tms.persistent.entity.Driver domainToEntity(Driver driver) {
        return modelMapper.map(driver, by.zadziarnouski.tms.persistent.entity.Driver.class);
    }

    public Driver viewToDomain(by.zadziarnouski.tms.rest.model.Driver driver) {
        return modelMapper.map(driver, Driver.class);
    }

    public by.zadziarnouski.tms.rest.model.Driver domainToView(Driver driver) {
        return modelMapper.map(driver, by.zadziarnouski.tms.rest.model.Driver.class);
    }

}
