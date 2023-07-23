package com.americo.taskhub.config;

import com.americo.taskhub.adapters.FilterCardByResponsibleAdapter;
import com.americo.taskhub.application.core.usecase.FilterCardByResponsibleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FilterCardByResponsibleConfig {


  @Bean
  public FilterCardByResponsibleUseCase filterCardByResponsibleUseCase(
    FilterCardByResponsibleAdapter filterCardByResponsibleAdapter) {
    return new FilterCardByResponsibleUseCase(filterCardByResponsibleAdapter);
  }
}
