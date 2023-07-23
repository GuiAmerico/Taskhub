package com.americo.taskhub.adapters.in.controller.request;

import com.americo.taskhub.application.core.domain.Priority;
import com.americo.taskhub.application.core.domain.Responsible;
import com.americo.taskhub.application.core.domain.State;
import com.americo.taskhub.application.core.domain.Tag;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CardRequest {

    private UUID id;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private String title;
    @Enumerated(EnumType.STRING)
    private State state;
    private Responsible responsible;
    @Enumerated(EnumType.STRING)
    private Set<Tag> tag;
    private String description;
    private ColumnRequest column;


}


