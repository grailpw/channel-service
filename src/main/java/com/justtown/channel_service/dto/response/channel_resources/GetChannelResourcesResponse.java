package com.justtown.channel_service.dto.response.channel_resources;

import com.justtown.channel_service.entity.ChannelResources;
import lombok.Data;

@Data
public class GetChannelResourcesResponse {
    private String profileImageURL;
    private String backgroundImageURL;
}
