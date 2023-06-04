package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.EditCardInputPort;
import com.americo.taskhub.application.ports.out.EditCardOutputPort;

import java.util.UUID;

public class EditCardUseCase implements EditCardInputPort {
    private final EditCardOutputPort editCardOutputPort;

    public EditCardUseCase(EditCardOutputPort editCardOutputPort) {
        this.editCardOutputPort = editCardOutputPort;
    }

    @Override
    public Card editCard(UUID cardId, Card cardToBeEdited) {
        return editCardOutputPort.editCard(cardId, cardToBeEdited);
    }
}
