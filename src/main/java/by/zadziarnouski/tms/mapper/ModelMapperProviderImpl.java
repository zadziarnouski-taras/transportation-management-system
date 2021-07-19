package by.zadziarnouski.tms.mapper;

import by.zadziarnouski.tms.domain.model.Route;
import by.zadziarnouski.tms.domain.service.DriverService;
import by.zadziarnouski.tms.persistent.entity.Bus;
import by.zadziarnouski.tms.persistent.entity.Driver;
import by.zadziarnouski.tms.persistent.entity.Station;
import org.modelmapper.AbstractConverter;
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
    private final DriverService driverService;

    @Autowired
    public ModelMapperProviderImpl(@Lazy DriverService driverService) {
        this.driverService = driverService;
    }

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

modelMapper.typeMap(by.zadziarnouski.tms.domain.model.Bus.class, by.zadziarnouski.tms.rest.viewModel.Bus.class).addMappings(mapper -> mapper.using(driverStringConverter()).map(by.zadziarnouski.tms.domain.model.Bus::getDriver, by.zadziarnouski.tms.rest.viewModel.Bus::setDriver));
        //        modelMapper.typeMap(by.zadziarnouski.tms.rest.viewModel.Bus.class, by.zadziarnouski.tms.domain.model.Bus.class).addMappings(mapper -> mapper.using(stringDriverConverter()).map(by.zadziarnouski.tms.rest.viewModel.Bus::getDriver, by.zadziarnouski.tms.domain.model.Bus::setDriver));

        return modelMapper;
    }

//    Converter<String, by.zadziarnouski.tms.domain.model.Driver> StringToDriver = new AbstractConverter<String, by.zadziarnouski.tms.domain.model.Driver>() {
//        @Override
//        protected by.zadziarnouski.tms.domain.model.Driver convert(String s) {
//            String[] name = s.split(" ");
//            by.zadziarnouski.tms.domain.model.Driver driver = driverService.getDriverByFirstAndLastName(name[1], name[0]);
//            return driver;
//        }
//    };

//    private Converter<String, by.zadziarnouski.tms.domain.model.Driver> stringDriverConverter() {
//        return context -> {
//            String[] driverName = context.getSource().split(" ");
//            return driverService.getDriverByFirstAndLastName(driverName[0], driverName[1]);
//        };
//    }

    private Converter<by.zadziarnouski.tms.domain.model.Driver,String> driverStringConverter() {
        return context -> context.getSource().getFirstName() + " " + context.getSource().getLastName();
    }
}
