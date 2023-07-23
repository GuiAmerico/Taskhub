package com.americo.taskhub.config.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Log4j2
@Aspect
@Component
public class AuditLogAspect {

    private static final String LOGGLY_URL = "http://logs-01.loggly.com/inputs/feee8465-cdb3-4d44-9f82-a7d779b787d5/tag/http//";

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final OkHttpClient httpClient = new OkHttpClient();

    @AfterReturning("@annotation(auditLog)")
    public void logAudit(JoinPoint joinPoint, AuditLog auditLog) {
        String methodName = joinPoint.getSignature().getName();
        String action = auditLog.action();
        LocalDateTime date = LocalDateTime.now();
        String logMessage = "Action: " + action + ", timestamp" + date + ", Method: " + methodName;

        log.info(logMessage);

        AuditLogEntry logEntry = new AuditLogEntry(action, methodName, logMessage);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonLog = gson.toJson(logEntry);

        sendLogToLoggly(jsonLog);
    }

    private void sendLogToLoggly(String jsonLog) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonLog);
        Request request = new Request.Builder()
                .url(LOGGLY_URL)
                .post(requestBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                log.info("Log successfully sent to Loggly.");
            } else {
                log.error("Failed to send log to Loggly. response code: {}", response.code());
            }
        } catch (Exception e) {
            log.error("Error sending log to Loggly: {}", e.getMessage());
        }
    }
}
    