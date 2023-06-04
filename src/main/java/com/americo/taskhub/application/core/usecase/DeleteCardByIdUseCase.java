package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.ports.in.DeleteCardByIdInputPort;
import com.americo.taskhub.application.ports.out.DeleteCardByIdOutputPort;

import java.util.UUID;

public class DeleteCardByIdUseCase implements DeleteCardByIdInputPort {

    private final DeleteCardByIdOutputPort deleteCardByIdOutputPort;

    public DeleteCardByIdUseCase(DeleteCardByIdOutputPort deleteCardByIdOutputPort) {
        this.deleteCardByIdOutputPort = deleteCardByIdOutputPort;
    }

    @Override
    public void deleteCard(UUID id) {
        deleteCardByIdOutputPort.deleteCard(id);
    }
}
