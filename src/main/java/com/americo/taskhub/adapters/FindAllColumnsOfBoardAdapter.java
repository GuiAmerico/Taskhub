package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.ColumnRepository;
import com.americo.taskhub.adapters.out.repository.entity.ColumnEntity;
import com.americo.taskhub.adapters.out.repository.mapper.ColumnEntityMapper;
import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.ports.in.FindAllColumnsOfBoardInputPort;
import com.americo.taskhub.application.ports.out.FindAllColumnsOfBoardOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Component
public class FindAllColumnsOfBoardAdapter implements FindAllColumnsOfBoardOutputPort {
    private final ColumnRepository columnRepository;
    private final ColumnEntityMapper mapper = new ColumnEntityMapper();

    @AuditLog(action = "Find All Columns of Board")
    @Override
    public List<Column> findAllColumnsOfBoard(UUID boardId) {
        List<ColumnEntity> columnEntities = columnRepository.findByBoard(boardId);
        if(columnEntities.isEmpty()){
            throw new ResponseStatusException(NOT_FOUND,"No columns results found for board with ID: " + boardId);
        }
        return mapper.toColumnList(columnEntities);

    }
}
