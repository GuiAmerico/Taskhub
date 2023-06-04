package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.domain.Card;

import java.util.UUID;

public interface MoveCardInputPort {
    void moveCard(UUID columnId , Card card);
}
