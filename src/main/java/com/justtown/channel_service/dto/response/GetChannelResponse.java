package com.justtown.channel_service.dto.response;

import com.justtown.channel_service.entity.Channel;
import com.justtown.channel_service.entity.ChannelDetails;
import com.justtown.channel_service.entity.ChannelResources;
import lombok.Data;

import java.time.Instant;

@Data
public class GetChannelResponse {
    private String channelName;
    private String displayName;
    private String description;
    private ChannelStatsResponse channelStats;
    private ChannelResourcesResponse channelResources;


    public GetChannelResponse(Channel channel) {
        channelName = channel.getChannelName();
        displayName = channel.getDisplayName();
        description = channel.getDescription();
        channelStats = new ChannelStatsResponse(channel.getChannelDetails());
        channelResources = new ChannelResourcesResponse(channel.getChannelResources());
    }

    @Data
    private static class ChannelStatsResponse {
        private Instant registeredAt;
        private Instant lastTimeOnlineAt;
        private Integer commentsQnt;
        private Integer likesQnt;
        private Integer watchedVideosQnt;
        private Integer uploadedVideosQnt;

        private ChannelStatsResponse(ChannelDetails channelDetails) {
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

    @Data
    private static class ChannelResourcesResponse {
        private String channelImageURL;
        private String backgroundImageURL;

        private ChannelResourcesResponse(ChannelResources channelResources) {
            if (channelResources == null) {
                return;
            }
            channelImageURL = channelResources.getChannelImageURL();
            backgroundImageURL = channelResources.getBackgroundImageURL();
        }
    }

}
