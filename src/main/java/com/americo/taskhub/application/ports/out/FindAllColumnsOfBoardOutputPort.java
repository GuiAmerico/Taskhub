package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Column;

import java.util.List;
import java.util.UUID;

public interface FindAllColumnsOfBoardOutputPort {
    List<Column> findAllColumnsOfBoard(UUID boardId);
}
