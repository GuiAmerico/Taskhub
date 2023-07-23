package com.americo.taskhub.config;

import com.americo.taskhub.adapters.CreateColumnAdapter;
import com.americo.taskhub.application.core.usecase.CreateColumnUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateColumnConfig {

  @Bean
  public CreateColumnUseCase createColumnUseCase(CreateColumnAdapter createColumnAdapter) {
    return new CreateColumnUseCase(createColumnAdapter);
  }
}
