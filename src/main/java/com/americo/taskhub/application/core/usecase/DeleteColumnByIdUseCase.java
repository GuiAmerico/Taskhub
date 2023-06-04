package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.ports.in.DeleteColumnByIdInputPort;
import com.americo.taskhub.application.ports.out.DeleteColumnByIdOutputPort;

import java.util.UUID;

public class DeleteColumnByIdUseCase implements DeleteColumnByIdInputPort {
    private final DeleteColumnByIdOutputPort deleteColumnByIdOutputPort;

    public DeleteColumnByIdUseCase(DeleteColumnByIdOutputPort deleteColumnByIdOutputPort) {
        this.deleteColumnByIdOutputPort = deleteColumnByIdOutputPort;
    }

    @Override
    public void deleteColumn(UUID id) {
        deleteColumnByIdOutputPort.deleteColumn(id);
    }
}
