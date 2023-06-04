package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Column;

import java.util.UUID;

public interface EditColumnOutputPort {
    Column editColumn(UUID columnId, Column columnToBeEdited);
}
