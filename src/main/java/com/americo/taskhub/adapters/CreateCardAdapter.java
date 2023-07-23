package com.americo.taskhub.adapters;

import com.americo.taskhub.adapters.out.repository.CardRepository;
import com.americo.taskhub.adapters.out.repository.entity.CardEntity;
import com.americo.taskhub.adapters.out.repository.mapper.CardEntityMapper;
import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.out.CreateCardOutputPort;
import com.americo.taskhub.config.log.AuditLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateCardAdapter implements CreateCardOutputPort {

  private final CardRepository cardRepository;
  private final CardEntityMapper mapper = new CardEntityMapper();

  @AuditLog(action = "Create Card")
  @Override
  public Card createCard(Card card) {
    CardEntity cardEntity = mapper.toCardEntity(card);
    cardEntity = cardRepository.save(cardEntity);

    return mapper.toCard(cardEntity);
  }
}
