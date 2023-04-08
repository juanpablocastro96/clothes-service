package com.sasha.store.clothesservice.service.clothes;

import com.sasha.store.clothesservice.dao.repositories.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ClothesConfig {
    private final ClothesRepository repository;


    @Bean
    public ClothesService clothesService(){
        return new ClothesService(repository);
    }
}
