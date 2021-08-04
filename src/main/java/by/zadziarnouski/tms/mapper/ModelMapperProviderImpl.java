package by.zadziarnouski.tms.mapper;

import by.zadziarnouski.tms.domain.model.Route;
import by.zadziarnouski.tms.domain.service.DriverService;
import by.zadziarnouski.tms.persistent.entity.Bus;
import by.zadziarnouski.tms.persistent.entity.Driver;
import by.zadziarnouski.tms.persistent.entity.Station;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Component
public class ModelMapperProviderImpl implements ModelMapperProvider {
    private ModelMapper modelMapper;

    @Override
    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    @PostConstruct
    private ModelMapper createModelMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);

        modelMapper.typeMap(Bus.class, by.zadziarnouski.tms.domain.model.Bus.class);
        modelMapper.typeMap(by.zadziarnouski.tms.domain.model.Bus.class, Bus.class);

        modelMapper.typeMap(Driver.class, by.zadziarnouski.tms.domain.model.Driver.class);
        modelMapper.typeMap(by.zadziarnouski.tms.domain.model.Driver.class, Driver.class);


        modelMapper.typeMap(Route.class, by.zadziarnouski.tms.persistent.entity.Route.class);
        modelMapper.typeMap(by.zadziarnouski.tms.persistent.entity.Route.class, Route.class);

        modelMapper.typeMap(Station.class, by.zadziarnouski.tms.domain.model.Station.class);
        modelMapper.typeMap(by.zadziarnouski.tms.domain.model.Station.class, Station.class);

        return modelMapper;
    }
}
