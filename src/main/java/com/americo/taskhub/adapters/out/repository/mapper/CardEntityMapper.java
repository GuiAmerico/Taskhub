package com.americo.taskhub.adapters.out.repository.mapper;

import com.americo.taskhub.adapters.out.repository.entity.CardEntity;
import com.americo.taskhub.application.core.domain.Card;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CardEntityMapper {
    private ModelMapper mapper = new ModelMapper();

    public Card toCard(CardEntity card) {
        return mapper.map(card, Card.class);
    }

    public CardEntity toCardEntity(Card card) {
        return mapper.map(card, CardEntity.class);
    }

    public List<Card> toCardList(List<CardEntity> cards) {
        return cards.stream().map(this::toCard).collect(Collectors.toList());
    }

    public List<CardEntity> toCardEntityList(List<Card> cards) {
        return cards.stream().map(this::toCardEntity).collect(Collectors.toList());
    }
}
