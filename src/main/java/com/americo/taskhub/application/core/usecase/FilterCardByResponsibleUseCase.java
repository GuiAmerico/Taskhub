package com.americo.taskhub.application.core.usecase;

import com.americo.taskhub.application.core.domain.Card;
import com.americo.taskhub.application.ports.in.FilterCardByResponsibleInputPort;
import com.americo.taskhub.application.ports.out.FilterCardByResponsibleOutputPort;

import java.util.List;
import java.util.UUID;

public class FilterCardByResponsibleUseCase implements FilterCardByResponsibleInputPort {

    private final FilterCardByResponsibleOutputPort filterCardByResponsibleOutputPort;

    public FilterCardByResponsibleUseCase(FilterCardByResponsibleOutputPort filterCardByResponsibleOutputPort) {
        this.filterCardByResponsibleOutputPort = filterCardByResponsibleOutputPort;
    }

    @Override
    public List<Card> filterCard(UUID responsibleId) {
        return filterCardByResponsibleOutputPort.filterCard(responsibleId);
    }
}
