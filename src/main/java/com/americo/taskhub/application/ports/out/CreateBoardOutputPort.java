package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Board;

public interface CreateBoardOutputPort {
    Board create(Board board);
}
