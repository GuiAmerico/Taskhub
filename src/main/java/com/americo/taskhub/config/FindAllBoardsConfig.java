package com.americo.taskhub.config;

import com.americo.taskhub.adapters.FindAllBoardsAdapter;
import com.americo.taskhub.application.core.usecase.FindAllBoardsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FindAllBoardsConfig {

  @Bean
  public FindAllBoardsUseCase findAllBoardsUseCase(FindAllBoardsAdapter findAllBoardsAdapter) {
    return new FindAllBoardsUseCase(findAllBoardsAdapter);
  }
}
