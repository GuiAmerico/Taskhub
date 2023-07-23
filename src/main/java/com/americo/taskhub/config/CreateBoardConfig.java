package com.americo.taskhub.config;

import com.americo.taskhub.adapters.CreateBoardAdapter;
import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.usecase.CreateBoardUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBoardConfig {

    @Bean
    public CreateBoardUseCase createBoardUseCase(CreateBoardAdapter createBoardAdapter){

        return new CreateBoardUseCase(createBoardAdapter);
    }
}
