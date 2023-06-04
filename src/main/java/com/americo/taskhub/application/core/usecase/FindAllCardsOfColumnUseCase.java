package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.FindAllCardsOfColumnInputPort;
import com.americo.taskhub.application.ports.out.FindAllCardsOfBoardOutputPort;

import java.util.List;
import java.util.UUID;

public class FindAllCardsOfColumnUseCase implements FindAllCardsOfColumnInputPort {
    private final FindAllCardsOfBoardOutputPort findAllCardsOfBoardOutputPort;

    public FindAllCardsOfColumnUseCase(FindAllCardsOfBoardOutputPort findAllCardsOfBoardOutputPort) {
        this.findAllCardsOfBoardOutputPort = findAllCardsOfBoardOutputPort;
    }

    @Override
    public List<Card> findAllCardsOfColumn(UUID cardId) {
        return findAllCardsOfBoardOutputPort.findAllCardsOfBoard(cardId);
    }
}
