package com.americo.taskhub.application.ports.out;

import java.util.UUID;

public interface DeleteColumnByIdOutputPort {
    void deleteColumn(UUID id);
}
