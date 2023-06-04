package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.MoveCardInputPort;
import com.americo.taskhub.application.ports.out.MoveCardOutputPort;

import java.util.UUID;

public class MoveCardUseCase implements MoveCardInputPort {
    private final MoveCardOutputPort moveCardOutputPort;

    public MoveCardUseCase(MoveCardOutputPort moveCardOutputPort) {
        this.moveCardOutputPort = moveCardOutputPort;
    }

    @Override
    public void moveCard(UUID columnId, Card card) {
        moveCardOutputPort.moveCard(columnId, card);
    }
}
