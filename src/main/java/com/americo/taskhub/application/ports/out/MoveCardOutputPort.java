package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Card;

import java.util.UUID;

public interface MoveCardOutputPort {
    void moveCard(UUID columnId , Card card);
}
