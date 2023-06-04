package com.americo.taskhub.config.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Log4j2
@Aspect
@Component
public class AuditLogAspect {

    private static final String LOGGLY_URL = "https://americo.loggly.com/";

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final OkHttpClient httpClient = new OkHttpClient();

    @AfterReturning("@annotation(auditLog)")
    public void logAudit(JoinPoint joinPoint, AuditLog auditLog) {
        String methodName = joinPoint.getSignature().getName();
        String action = auditLog.action();
        long timestamp = auditLog.timestamp();
        LocalDateTime date =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone
                        .getDefault().toZoneId());
        String logMessage = "Action: " + action + "timestamp" + date + ", Method: " + methodName;

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
    