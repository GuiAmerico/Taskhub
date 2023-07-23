package com.americo.taskhub.config;

import com.americo.taskhub.adapters.DeleteColumnByIdAdapter;
import com.americo.taskhub.application.core.usecase.DeleteColumnByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteColumnByIdConfig {

  @Bean
  public DeleteColumnByIdUseCase deleteColumnByIdUseCase(
    DeleteColumnByIdAdapter deleteColumnByIdAdapter) {
    return new DeleteColumnByIdUseCase(deleteColumnByIdAdapter);
  }


}
