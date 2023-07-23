package com.americo.taskhub.config;

import com.americo.taskhub.adapters.EditCardAdapter;
import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.core.usecase.EditCardUseCase;
import com.americo.taskhub.application.ports.in.EditCardInputPort;
import com.americo.taskhub.application.ports.out.EditCardOutputPort;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EditCardConfig {

    @Bean
    public EditCardUseCase editCardUseCase(EditCardAdapter editCardAdapter) {
        return new EditCardUseCase(editCardAdapter);
    }
}
