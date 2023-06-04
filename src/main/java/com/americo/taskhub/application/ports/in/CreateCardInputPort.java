package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.domain.Card;

public interface CreateCardInputPort {
    Card createCard(Card card);
}
