package com.americo.taskhub.config;

import com.americo.taskhub.adapters.CreateCardAdapter;
import com.americo.taskhub.application.core.usecase.CreateCardUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateCardConfig {

  @Bean
  public CreateCardUseCase createCardUseCase(CreateCardAdapter createCardAdapter){
    return new CreateCardUseCase(createCardAdapter);
  }
}
