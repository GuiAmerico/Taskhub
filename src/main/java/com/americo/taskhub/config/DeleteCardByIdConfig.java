package com.americo.taskhub.config;

import com.americo.taskhub.adapters.DeleteCardByIdAdapter;
import com.americo.taskhub.application.core.usecase.DeleteCardByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCardByIdConfig {


  @Bean
  public DeleteCardByIdUseCase deleteCardByIdUseCase(DeleteCardByIdAdapter deleteCardByIdAdapter) {
    return new DeleteCardByIdUseCase(deleteCardByIdAdapter);
  }
}
