package com.americo.taskhub.adapters;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.americo.taskhub.adapters.out.repository.ColumnRepository;
import com.americo.taskhub.adapters.out.repository.ColumnRepository;
import com.americo.taskhub.adapters.out.repository.entity.ColumnEntity;
import com.americo.taskhub.adapters.out.repository.mapper.ColumnEntityMapper;
import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.ports.out.EditColumnOutputPort;
import com.americo.taskhub.application.ports.out.EditColumnOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Component
public class EditColumnAdapter implements EditColumnOutputPort {
    private final ColumnRepository columnRepository;
    private final ColumnEntityMapper mapper = new ColumnEntityMapper();

    @AuditLog(action = "Edit Column")
    @Override
    public Column editColumn(UUID columnId, Column columnToBeEdited) {
        ColumnEntity columnEntity = columnRepository.findById(columnId)
          .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No column results for ID: " + columnId));
        columnEntity = mapper.toColumnEntity(columnToBeEdited);
        columnEntity.setId(columnId);

        return mapper.toColumn(columnRepository.save(columnEntity));
    }
}
