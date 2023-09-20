package com.justtown.channel_service.util;

import com.justtown.channel_service.dto.response.AppErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtils {

    public ResponseEntity<?> errorResponse(HttpStatus status, String errorMessage) {
        return new ResponseEntity<>(
                new AppErrorResponse(
                        status.value(),
                        errorMessage
                )
                , status
        );
    }

}
