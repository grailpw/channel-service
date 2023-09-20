package com.justtown.channel_service.dto.request;

import lombok.Data;

@Data
public class SetChannelRequest {
    private String channelName;
    private String displayName;
    private String description;
}
