package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.FindAllCardsOfColumnInputPort;
import com.americo.taskhub.application.ports.out.FindAllCardsOfColumnOutputPort;

import java.util.List;
import java.util.UUID;

public class FindAllCardsOfColumnUseCase implements FindAllCardsOfColumnInputPort {
    private final FindAllCardsOfColumnOutputPort findAllCardsOfBoardOutputPort;

    public FindAllCardsOfColumnUseCase(FindAllCardsOfColumnOutputPort findAllCardsOfColumnOutputPort) {
        this.findAllCardsOfBoardOutputPort = findAllCardsOfColumnOutputPort;
    }

    @Override
    public List<Card> findAllCardsOfColumn(UUID columnId) {
        return findAllCardsOfBoardOutputPort.findAllCardsOfColumn(columnId);
    }
}
