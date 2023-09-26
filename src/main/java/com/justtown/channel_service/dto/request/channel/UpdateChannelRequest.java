package com.justtown.channel_service.dto.request.channel;

import lombok.Data;

@Data
public class UpdateChannelRequest {
    private String displayName;
    private String description;
}
