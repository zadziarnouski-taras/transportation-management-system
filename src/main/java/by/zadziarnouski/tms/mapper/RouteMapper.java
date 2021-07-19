package by.zadziarnouski.tms.mapper;

import by.zadziarnouski.tms.domain.model.Route;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public RouteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Route entityToDomain(by.zadziarnouski.tms.persistent.entity.Route route) {
        return modelMapper.map(route, Route.class);
    }

    public by.zadziarnouski.tms.persistent.entity.Route domainToEntity(Route route) {
        return modelMapper.map(route, by.zadziarnouski.tms.persistent.entity.Route.class);
    }

    public Route viewToDomain(by.zadziarnouski.tms.rest.model.Route route) {
        return modelMapper.map(route, Route.class);
    }

    public by.zadziarnouski.tms.rest.model.Route domainToView(Route route) {
        return modelMapper.map(route, by.zadziarnouski.tms.rest.model.Route.class);
    }
}
