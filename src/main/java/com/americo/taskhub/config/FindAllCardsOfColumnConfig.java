package com.americo.taskhub.config;

import com.americo.taskhub.adapters.FindAllCardsOfColumnAdapter;
import com.americo.taskhub.application.core.usecase.FindAllCardsOfColumnUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FindAllCardsOfColumnConfig {

  @Bean
  public FindAllCardsOfColumnUseCase findAllCardsOfColumnUseCase(
    FindAllCardsOfColumnAdapter findAllCardsOfColumnAdapter) {
    return new FindAllCardsOfColumnUseCase(findAllCardsOfColumnAdapter);
  }
}
