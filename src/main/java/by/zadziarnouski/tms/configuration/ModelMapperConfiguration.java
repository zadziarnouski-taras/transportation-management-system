package by.zadziarnouski.tms.configuration;

import by.zadziarnouski.tms.mapper.ModelMapperProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ModelMapperConfiguration {
    private final ModelMapperProvider modelMapperProvider;

    @Autowired
    public ModelMapperConfiguration(ModelMapperProvider modelMapperProvider) {
        this.modelMapperProvider = modelMapperProvider;
    }

    @Bean
    public ModelMapper modelMapper() {
        return modelMapperProvider.getModelMapper();
    }
}
