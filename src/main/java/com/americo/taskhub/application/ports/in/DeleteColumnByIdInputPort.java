package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;

import java.util.UUID;

public interface DeleteColumnByIdInputPort {
    void deleteColumn(UUID id);
}
