package com.americo.taskhub.adapters.out.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "_card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private String title;
    @Enumerated(EnumType.STRING)
    private State state;
    @Embedded
    private Responsible responsible;

    @Enumerated(EnumType.STRING)
    private Set<Tag> tag;
    private String description;
    @ManyToOne
    private ColumnEntity column;


}


