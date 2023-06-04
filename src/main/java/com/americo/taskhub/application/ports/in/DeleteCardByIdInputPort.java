package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;

import java.util.UUID;

public interface DeleteCardByIdInputPort {
    void deleteCard(UUID id);
}
