package com.americo.taskhub.config;

import com.americo.taskhub.adapters.FindAllBoardsByWorkspaceAdapter;
import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.usecase.FindAllBoardsByWorkspaceUseCase;
import com.americo.taskhub.application.ports.in.FindAllBoardsByWorkspaceInputPort;
import com.americo.taskhub.application.ports.out.FindAllBoardsByWorkspaceOutputPort;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FindAllBoardsByWorkspaceConfig {

    @Bean
    public FindAllBoardsByWorkspaceUseCase findAllBoardsByWorkspaceUseCase(
      FindAllBoardsByWorkspaceAdapter findAllBoardsByWorkspaceAdapter) {
        return new FindAllBoardsByWorkspaceUseCase(findAllBoardsByWorkspaceAdapter);
    }

}
