package by.zadziarnouski.tms.mapper;

import by.zadziarnouski.tms.domain.model.Bus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public BusMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Bus entityToDomain(by.zadziarnouski.tms.persistent.entity.Bus bus) {
        return modelMapper.map(bus, Bus.class);
    }

    public by.zadziarnouski.tms.persistent.entity.Bus domainToEntity(Bus bus) {
        return modelMapper.map(bus, by.zadziarnouski.tms.persistent.entity.Bus.class);
    }

    public Bus viewToDomain(by.zadziarnouski.tms.rest.viewModel.Bus bus) {
        return modelMapper.map(bus, Bus.class);
    }

    public by.zadziarnouski.tms.rest.viewModel.Bus domainToView(Bus bus) {
        return modelMapper.map(bus, by.zadziarnouski.tms.rest.viewModel.Bus.class);
    }
}
