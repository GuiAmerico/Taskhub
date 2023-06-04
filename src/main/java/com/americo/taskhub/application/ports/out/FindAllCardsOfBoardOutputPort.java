package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Card;

import java.util.List;
import java.util.UUID;

public interface FindAllCardsOfBoardOutputPort {
    List<Card> findAllCardsOfBoard(UUID boardId);
}
