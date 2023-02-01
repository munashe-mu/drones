package com.umlimi.drones.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MUNASHE MURIMI
 * @created 28/1/2023
 **/
@Configuration
public class BeanConfigs {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
