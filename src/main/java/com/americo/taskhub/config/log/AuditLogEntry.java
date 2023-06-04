package com.americo.taskhub.config.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuditLogEntry {
    private String action;
    private String methodName;
    private String logMessage;
}
