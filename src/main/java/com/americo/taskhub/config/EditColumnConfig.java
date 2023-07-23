package com.americo.taskhub.config;

import com.americo.taskhub.adapters.EditCardAdapter;
import com.americo.taskhub.adapters.EditColumnAdapter;
import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.core.usecase.EditColumnUseCase;
import com.americo.taskhub.application.ports.in.EditColumnInputPort;
import com.americo.taskhub.application.ports.out.EditColumnOutputPort;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EditColumnConfig {

    @Bean
    public EditColumnUseCase editColumnUseCase(EditColumnAdapter editColumnAdapter) {
        return new EditColumnUseCase(editColumnAdapter);
    }
}
