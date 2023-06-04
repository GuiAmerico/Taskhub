package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Card;

public interface CreateCardOutputPort {
    Card createCard(Card card);
}
