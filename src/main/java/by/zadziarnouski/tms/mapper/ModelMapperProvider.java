package by.zadziarnouski.tms.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public interface ModelMapperProvider {
    ModelMapper getModelMapper();
}
