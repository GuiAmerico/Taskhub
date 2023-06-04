package com.americo.taskhub.application.core.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Responsible {

    private String responsibleName;
}
