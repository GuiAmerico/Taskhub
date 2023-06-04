package com.americo.taskhub.application.core.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "_column")
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int wip;
    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
    @ManyToOne
    private Board board;
}
