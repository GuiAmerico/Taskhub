package com.americo.taskhub.config;

import com.americo.taskhub.adapters.MoveCardAdapter;
import com.americo.taskhub.application.core.usecase.MoveCardUseCase;
import com.americo.taskhub.application.ports.in.MoveCardInputPort;
import com.americo.taskhub.application.ports.out.MoveCardOutputPort;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MoveCardConfig {

    @Bean
    public MoveCardUseCase moveCardUseCase(MoveCardAdapter moveCardAdapter) {
        return new MoveCardUseCase(moveCardAdapter);
    }
}
