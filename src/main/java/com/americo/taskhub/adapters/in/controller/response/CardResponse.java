package com.americo.taskhub.adapters.in.controller.response;

import com.americo.taskhub.application.core.domain.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CardResponse {

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
    private ColumnResponse column;


}


