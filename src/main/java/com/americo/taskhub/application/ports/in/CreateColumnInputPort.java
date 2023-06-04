package com.americo.taskhub.application.ports.in;

import com.americo.taskhub.application.core.domain.Board;
import com.americo.taskhub.application.core.domain.Column;

public interface CreateColumnInputPort {
    Column createColumn(Column column);
}
