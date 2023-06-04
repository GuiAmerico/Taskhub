package com.americo.taskhub.application.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDateTime created;
    @Embedded
    private Responsible responsible;
    @OneToMany
    private List<Column> columns = new ArrayList<>();

}
