package com.justtown.channel_service.dto.response.channel_details;

import com.justtown.channel_service.entity.ChannelDetails;
import lombok.Data;

import java.time.Instant;

@Data
public class GetChannelDetailsResponse {
    private Instant registeredAt;
    private Instant lastTimeOnlineAt;
    private Integer commentsQnt;
    private Integer likesQnt;
    private Integer watchedVideosQnt;
    private Integer uploadedVideosQnt;

    public GetChannelDetailsResponse(ChannelDetails channelDetails) {
        if (channelDetails == null) {
            return;
        }
        registeredAt = channelDetails.getRegisteredAt();
        lastTimeOnlineAt = channelDetails.getLastTimeOnlineAt();
        commentsQnt = channelDetails.getCommentsQnt();
        likesQnt = channelDetails.getLikesQnt();
        watchedVideosQnt = channelDetails.getWatchedVideosQnt();
        uploadedVideosQnt = channelDetails.getUploadedVideosQnt();
    }
}
