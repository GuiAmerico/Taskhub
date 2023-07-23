package com.americo.taskhub.adapters.out.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "_board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String workspace;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime created;
    @Embedded
    private Responsible responsible;
    @OneToMany(mappedBy = "board")
    private List<ColumnEntity> columns = new ArrayList<>();


}
