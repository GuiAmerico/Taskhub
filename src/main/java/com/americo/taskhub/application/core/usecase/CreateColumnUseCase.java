package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.ports.in.CreateColumnInputPort;
import com.americo.taskhub.application.ports.out.CreateCardOutputPort;
import com.americo.taskhub.application.ports.out.CreateColumnOutputPort;

public class CreateColumnUseCase implements CreateColumnInputPort {

    private final CreateColumnOutputPort createColumnOutputPort;

    public CreateColumnUseCase(CreateColumnOutputPort createColumnOutputPort) {
        this.createColumnOutputPort = createColumnOutputPort;
    }

    @Override
    public Column createColumn(Column column) {
        return createColumnOutputPort.createColumn(column);
    }
}
