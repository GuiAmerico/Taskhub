package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.ports.in.FindAllBoardsInputPort;
import com.americo.taskhub.application.ports.out.FindAllBoardsOutputPort;

import java.util.List;

public class FindAllBoardsUseCase implements FindAllBoardsInputPort {
    private final FindAllBoardsOutputPort findAllBoardsOutputPort;

    public FindAllBoardsUseCase(FindAllBoardsOutputPort findAllBoardsOutputPort) {
        this.findAllBoardsOutputPort = findAllBoardsOutputPort;
    }

    @Override
    public List<Board> findAllBoards() {
        return findAllBoardsOutputPort.findAllBoards();
    }
}
