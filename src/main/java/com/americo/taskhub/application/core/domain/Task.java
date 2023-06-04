package com.americo.taskhub.application.core.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Priority priority;
    private String title;
    private State state;
    @Embedded
    private Responsible responsible;
    private Set<Tag> tag;
    private String Description;
    @ManyToOne
    private Column column;


}


