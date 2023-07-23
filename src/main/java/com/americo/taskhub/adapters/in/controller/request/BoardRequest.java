package com.americo.taskhub.adapters.in.controller.request;

import com.americo.taskhub.adapters.out.repository.entity.Responsible;
import com.americo.taskhub.adapters.out.repository.entity.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class BoardRequest {
    private UUID id;
    @NotBlank(message = "Title of the board request is required")
    private String title;

    @NotBlank(message = "Workspace of the board request is required")
    private String workspace;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;
    private LocalDateTime created;
    @Embedded
    private Responsible responsible;
    private List<ColumnRequest> columns = new ArrayList<>();
}
