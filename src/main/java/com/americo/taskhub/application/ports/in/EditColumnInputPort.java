package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.domain.Column;

import java.util.UUID;

public interface EditColumnInputPort {
    Column editColumn(UUID columnId, Column columnToBeEdited);
}
