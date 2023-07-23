package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.ColumnRepository;
import com.americo.taskhub.application.ports.out.DeleteColumnByIdOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteColumnByIdAdapter implements DeleteColumnByIdOutputPort {

  private final ColumnRepository columnRepository;

  @AuditLog(action = "Delete Column")
  @Override
  public void deleteColumn(UUID id) {
    columnRepository.deleteById(id);
  }
}
