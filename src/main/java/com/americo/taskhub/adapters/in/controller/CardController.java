package com.americo.taskhub.adapters.in.controller;

import com.americo.taskhub.adapters.in.controller.mapper.CardMapper;
import com.americo.taskhub.adapters.in.controller.request.CardRequest;
import com.americo.taskhub.adapters.in.controller.response.CardResponse;
import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RequestMapping("/v1/cards")
@RestController
public class CardController {

    private final CreateCardInputPort createCardInputPort;
    private final DeleteCardByIdInputPort deleteCardByIdInputPort;
    private final EditCardInputPort editCardInputPort;
    private final FilterCardByResponsibleInputPort filterCardByResponsibleInputPort;
    private final FindAllCardsOfColumnInputPort findAllCardsOfColumnInputPort;
    private final MoveCardInputPort moveCardInputPort;

    private final CardMapper mapper = new CardMapper();

    @PostMapping
    public ResponseEntity<CardResponse> createCard(@RequestBody CardRequest cardRequest) {
        Card card = mapper.toCard(cardRequest);
        CardResponse cardResponse = mapper.toCardResponse(createCardInputPort.createCard(card));
        return ResponseEntity.status(CREATED).body(cardResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable UUID id) {
        deleteCardByIdInputPort.deleteCard(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<CardResponse> editCard(@PathVariable UUID cardId, @RequestBody CardRequest cardRequest) {
        Card card = mapper.toCard(cardRequest);
        CardResponse cardResponse = mapper.toCardResponse(editCardInputPort.editCard(cardId, card));
        return ResponseEntity.status(OK).body(cardResponse);
    }

    @GetMapping("/{responsibleName}")
    public ResponseEntity<List<CardResponse>> filterCardsByResponsible(@PathVariable String responsibleName) {
        List<Card> cards = filterCardByResponsibleInputPort.filterCard(responsibleName);// responsibleName
        List<CardResponse> cardResponses = mapper.toCardResponseList(cards);
        return ResponseEntity.status(OK).body(cardResponses);
    }

    @GetMapping("/{columnId}")
    public ResponseEntity<List<CardResponse>> findAll(@PathVariable UUID columnId) {
        List<Card> cards = findAllCardsOfColumnInputPort.findAllCardsOfColumn(columnId);
        List<CardResponse> cardResponses = mapper.toCardResponseList(cards);
        return ResponseEntity.status(OK).body(cardResponses);
    }

    @GetMapping("/{cardId}/move/{columnId}")
    public ResponseEntity<Void> moveCard(@PathVariable UUID cardId, @PathVariable UUID columnId) {
        moveCardInputPort.moveCard(cardId,columnId);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
