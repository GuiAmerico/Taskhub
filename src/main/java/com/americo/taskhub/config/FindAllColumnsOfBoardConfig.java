package com.americo.taskhub.config;

import com.americo.taskhub.adapters.FindAllColumnsOfBoardAdapter;
import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.core.usecase.FindAllColumnsOfBoardUseCase;
import com.americo.taskhub.application.ports.in.FindAllColumnsOfBoardInputPort;
import com.americo.taskhub.application.ports.out.FindAllColumnsOfBoardOutputPort;
import java.util.List;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FindAllColumnsOfBoardConfig  {

    @Bean
    public FindAllColumnsOfBoardUseCase findAllColumnsOfBoardUseCase(
      FindAllColumnsOfBoardAdapter findAllColumnsOfBoardAdapter) {
        return new FindAllColumnsOfBoardUseCase(findAllColumnsOfBoardAdapter);
    }
}
