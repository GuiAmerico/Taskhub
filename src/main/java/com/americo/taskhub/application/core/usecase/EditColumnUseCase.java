package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.ports.in.EditCardInputPort;
import com.americo.taskhub.application.ports.in.EditColumnInputPort;
import com.americo.taskhub.application.ports.out.EditCardOutputPort;
import com.americo.taskhub.application.ports.out.EditColumnOutputPort;
import java.util.UUID;

public class EditColumnUseCase implements EditColumnInputPort {
    private final EditColumnOutputPort editColumnOutputPort;

    public EditColumnUseCase(EditColumnOutputPort editColumnOutputPort) {
        this.editColumnOutputPort = editColumnOutputPort;
    }

    @Override
    public Column editColumn(UUID columnId, Column columnToBeEdited) {
        return editColumnOutputPort.editColumn(columnId, columnToBeEdited);
    }
}
