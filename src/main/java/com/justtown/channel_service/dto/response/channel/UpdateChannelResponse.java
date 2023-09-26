package com.justtown.channel_service.dto.response.channel;

import com.justtown.channel_service.dto.response.channel.GetChannelResponse;
import com.justtown.channel_service.entity.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateChannelResponse extends GetChannelResponse {
    private boolean isUpdated;

    public UpdateChannelResponse(Channel channel, boolean isUpdated) {
        super(channel);
        this.isUpdated = isUpdated;
    }
}
