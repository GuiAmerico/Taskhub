package com.americo.taskhub.application.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Column {

    private UUID id;
    private String title;
    private int wip;
    private List<Card> cards = new ArrayList<>();
    private Board board;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWip() {
        return wip;
    }

    public void setWip(int wip) {
        this.wip = wip;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
