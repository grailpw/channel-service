package com.justtown.channel_service.dto.response.channel;

import com.justtown.channel_service.entity.Channel;
import com.justtown.channel_service.entity.ChannelDetails;
import com.justtown.channel_service.entity.ChannelResources;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class GetChannelResponse {
    private String channelName;
    private String displayName;
    private String description;


    public GetChannelResponse(Channel channel) {
        channelName = channel.getChannelName();
        displayName = channel.getDisplayName();
        description = channel.getDescription();
    }

}
