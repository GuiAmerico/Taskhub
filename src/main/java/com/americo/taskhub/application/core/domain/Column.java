package com.americo.taskhub.application.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Column {

    private UUID id;
    private String name;
    private int wip;
    private List<Card> cards = new ArrayList<>();
    private Board board;
}
