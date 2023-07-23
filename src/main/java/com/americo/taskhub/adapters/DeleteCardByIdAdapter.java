package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.CardRepository;
import com.americo.taskhub.application.ports.out.DeleteCardByIdOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCardByIdAdapter implements DeleteCardByIdOutputPort {

  private final CardRepository cardRepository;

  @AuditLog(action = "Delete Card")
  @Override
  public void deleteCard(UUID id) {
    cardRepository.deleteById(id);
  }
}
