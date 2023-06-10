package com.americo.taskhub.application.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Board {

    private UUID id;
    private String title;
    private String workspace;
    private Visibility visibility;
    private LocalDateTime created;
    private Responsible responsible;
    private List<Column> columns = new ArrayList<>();

}
