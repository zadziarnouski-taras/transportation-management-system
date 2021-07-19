package by.zadziarnouski.tms.mapper;

import by.zadziarnouski.tms.domain.model.Station;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StationMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public StationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Station entityToDomain(by.zadziarnouski.tms.persistent.entity.Station station) {
        return modelMapper.map(station, Station.class);
    }

    public by.zadziarnouski.tms.persistent.entity.Station domainToEntity(Station station) {
        return modelMapper.map(station, by.zadziarnouski.tms.persistent.entity.Station.class);
    }

    public Station viewToDomain(by.zadziarnouski.tms.rest.model.Station station) {
        return modelMapper.map(station, Station.class);
    }

    public by.zadziarnouski.tms.rest.model.Station domainToView(Station station) {
        return modelMapper.map(station, by.zadziarnouski.tms.rest.model.Station.class);
    }
}
