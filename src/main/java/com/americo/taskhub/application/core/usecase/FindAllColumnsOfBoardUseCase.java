package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.ports.in.FindAllColumnsOfBoardInputPort;
import com.americo.taskhub.application.ports.out.FindAllColumnsOfBoardOutputPort;

import java.util.List;
import java.util.UUID;

public class FindAllColumnsOfBoardUseCase implements FindAllColumnsOfBoardInputPort {
    private final FindAllColumnsOfBoardOutputPort findAllColumnsOfBoardOutputPort;

    public FindAllColumnsOfBoardUseCase(FindAllColumnsOfBoardOutputPort findAllColumnsOfBoardOutputPort) {
        this.findAllColumnsOfBoardOutputPort = findAllColumnsOfBoardOutputPort;
    }

    @Override
    public List<Column> findAllColumnsOfBoard(UUID boardId) {
        return findAllColumnsOfBoardOutputPort.findAllColumnsOfBoard(boardId);
    }
}
