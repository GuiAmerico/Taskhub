package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;

public interface CreateBoardInputPort {
    Board createBoard(Board board);
}
