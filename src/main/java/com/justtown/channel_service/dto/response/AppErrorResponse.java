package com.justtown.channel_service.dto.response;

import lombok.Data;

import java.time.Instant;

@Data
public class AppErrorResponse {
    private int status;
    private String errorMessage;
    private Instant timestamp;

    public AppErrorResponse(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
        timestamp = Instant.now();
    }
}
