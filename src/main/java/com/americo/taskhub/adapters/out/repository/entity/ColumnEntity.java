package com.americo.taskhub.adapters.out.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Table(name = "_column")
public class ColumnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private int wip;
    @OneToMany(mappedBy = "column")
    private List<CardEntity> cards = new ArrayList<>();
    @ManyToOne
    private BoardEntity board;
}
