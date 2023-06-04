package com.americo.taskhub.application.ports.out;

import java.util.UUID;

public interface DeleteCardByIdOutputPort {
    void deleteCard(UUID id);
}
