package com.americo.taskhub.application.core.domain;

import java.util.Set;
import java.util.UUID;

public class Card {

    private UUID id;
    private Priority priority;
    private String title;
    private State state;
    private Responsible responsible;
    private Set<Tag> tag;
    private String Description;
    private Column column;


}


