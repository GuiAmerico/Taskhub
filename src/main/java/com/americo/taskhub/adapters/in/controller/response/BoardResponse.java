package com.americo.taskhub.adapters.in.controller.response;

import com.americo.taskhub.adapters.out.repository.entity.ColumnEntity;
import com.americo.taskhub.adapters.out.repository.entity.Responsible;
import com.americo.taskhub.adapters.out.repository.entity.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class BoardResponse {
    private UUID id;
    private String title;
    private String workspace;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime created;
    @Embedded
    private Responsible responsible;
    private List<ColumnResponse> columns = new ArrayList<>();
}
