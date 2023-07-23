package com.americo.taskhub.adapters.in.controller.response;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.domain.Card;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ColumnResponse {

    private UUID id;
    private String title;
    private int wip;
    private List<CardResponse> cards = new ArrayList<>();
    private BoardResponse board;
}
