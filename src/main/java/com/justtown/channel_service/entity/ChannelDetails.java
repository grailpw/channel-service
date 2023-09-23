package com.justtown.channel_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@Table(name = "t_channel_details")
public class ChannelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "channel_details_sequence")
    @SequenceGenerator(name = "channel_details_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "registeredAt")
    private Instant registeredAt;

    @Column(name = "lastTimeOnline")
    private Instant lastTimeOnlineAt;

    @Column(name = "commentsQnt")
    private Integer commentsQnt;

    @Column(name = "likesQnt")
    private Integer likesQnt;

    @Column(name = "watchedVideosQnt")
    private Integer watchedVideosQnt;

    @Column(name = "uploadedVideosQnt")
    private Integer uploadedVideosQnt;

    public class Builder {
        public static ChannelDetails newChannelDetails() {
            ChannelDetails channelDetails = new ChannelDetails();
            channelDetails.setRegisteredAt(Instant.now());
            channelDetails.setLastTimeOnlineAt(Instant.now());
            channelDetails.setCommentsQnt(0);
            channelDetails.setLikesQnt(0);
            channelDetails.setWatchedVideosQnt(0);
            channelDetails.setUploadedVideosQnt(0);
            return channelDetails;
        }
    }

}
