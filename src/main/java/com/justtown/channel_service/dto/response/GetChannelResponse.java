package com.justtown.channel_service.dto.response;

import com.justtown.channel_service.entity.Channel;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class GetChannelResponse {
    private String channelName;
    private String displayName;
    private String description;
    private Instant registeredAt;
    private Instant lastTimeOnlineAt;
    private Integer commentsQnt;
    private Integer likesQnt;
    private Integer watchedVideosQnt;
    private Integer uploadedVideosQnt;

    public GetChannelResponse(Channel channel) {
        channelName = channel.getChannelName();
        displayName = channel.getDisplayName();
        description = channel.getDescription();
        registeredAt = channel.getRegisteredAt();
        lastTimeOnlineAt = channel.getLastTimeOnlineAt();
        commentsQnt = channel.getCommentsQnt();
        likesQnt = channel.getLikesQnt();
        watchedVideosQnt = channel.getWatchedVideosQnt();
        uploadedVideosQnt = channel.getUploadedVideosQnt();
    }

}
