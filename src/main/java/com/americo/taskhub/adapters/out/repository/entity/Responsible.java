package com.americo.taskhub.adapters.out.repository.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Responsible {

    private String responsibleName;
}
