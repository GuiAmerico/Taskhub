package com.americo.taskhub.application.ports.out;

import com.americo.taskhub.application.core.domain.Column;

public interface CreateColumnOutputPort {
    Column createColumn(Column column);
}
