package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.ColumnRepository;
import com.americo.taskhub.adapters.out.repository.entity.ColumnEntity;
import com.americo.taskhub.adapters.out.repository.mapper.ColumnEntityMapper;
import com.americo.taskhub.application.core.domain.Column;
import com.americo.taskhub.application.ports.out.CreateColumnOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateColumnAdapter implements CreateColumnOutputPort {


  private final ColumnRepository columnRepository;
  private final ColumnEntityMapper mapper = new ColumnEntityMapper();

  @AuditLog(action = "Create Column")
  @Override
  public Column createColumn(Column column) {
    ColumnEntity columnEntity = mapper.toColumnEntity(column);
    columnEntity = columnRepository.save(columnEntity);
    return mapper.toColumn(columnEntity);
  }
}
