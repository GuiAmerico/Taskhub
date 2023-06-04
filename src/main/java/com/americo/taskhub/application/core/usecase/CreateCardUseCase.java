package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.CreateCardInputPort;
import com.americo.taskhub.application.ports.out.CreateCardOutputPort;

public class CreateCardUseCase implements CreateCardInputPort {

    private final CreateCardOutputPort createCardOutputPort;

    public CreateCardUseCase(CreateCardOutputPort createCardOutputPort) {
        this.createCardOutputPort = createCardOutputPort;
    }

    @Override
    public Card createCard(Card card) {
        return createCardOutputPort.createCard(card);
    }
}
