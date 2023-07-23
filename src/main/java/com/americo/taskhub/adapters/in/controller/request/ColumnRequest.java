package com.americo.taskhub.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ColumnRequest {

    private UUID id;
    @NotBlank(message = "Title of the Column request is required")
    private String title;
    private int wip;
    private List<CardRequest> cards = new ArrayList<>();
    private BoardRequest board;
}
