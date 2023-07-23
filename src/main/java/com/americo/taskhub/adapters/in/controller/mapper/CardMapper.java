package com.americo.taskhub.adapters.in.controller.mapper;

import com.americo.taskhub.adapters.in.controller.request.CardRequest;
import com.americo.taskhub.adapters.in.controller.response.CardResponse;
import com.americo.taskhub.application.core.domain.Card;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CardMapper {
    private ModelMapper mapper = new ModelMapper();

    public Card toCard(CardRequest card) {
        return mapper.map(card, Card.class);
    }

    public CardResponse toCardResponse(Card card) {
        return mapper.map(card, CardResponse.class);
    }

    public List<Card> toCardList(List<CardRequest> cards) {
        return cards.stream().map(this::toCard).collect(Collectors.toList());
    }

    public List<CardResponse> toCardResponseList(List<Card> cards) {
        return cards.stream().map(this::toCardResponse).collect(Collectors.toList());
    }
}
