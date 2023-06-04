package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.domain.Column;

import java.util.List;
import java.util.UUID;

public interface FindAllColumnsOfBoardInputPort {
    List<Column> findAllColumnsOfBoard(UUID boardId);
}
