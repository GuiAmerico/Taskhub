package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.ports.in.CreateBoardInputPort;
import com.americo.taskhub.application.ports.out.CreateBoardOutputPort;

public class CreateBoardUseCase implements CreateBoardInputPort {

    private final CreateBoardOutputPort createBoardOutputPort;

    public CreateBoardUseCase(CreateBoardOutputPort createBoardOutputPort) {
        this.createBoardOutputPort = createBoardOutputPort;
    }

    @Override
    public Board createBoard(Board board) {
        return createBoardOutputPort.create(board);
    }
}
