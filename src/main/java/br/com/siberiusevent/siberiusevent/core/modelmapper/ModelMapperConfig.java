package br.com.siberiusevent.siberiusevent.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper ModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}
