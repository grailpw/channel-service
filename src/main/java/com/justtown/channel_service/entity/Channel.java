package com.justtown.channel_service.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "t_channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "channel_sequence")
    @SequenceGenerator(name = "channel_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "channelName", unique = true, nullable = false)
    private String channelName;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "description")
    private String description;

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


    public static class Builder {
        public static Channel newChannel(String channelName) {
            Channel channel = new Channel();
            channel.setChannelName(channelName);
            channel.setDisplayName(channelName);
            channel.setDescription("");
            channel.setRegisteredAt(Instant.now());
            channel.setLastTimeOnlineAt(Instant.now());
            channel.setCommentsQnt(0);
            channel.setLikesQnt(0);
            channel.setWatchedVideosQnt(0);
            channel.setUploadedVideosQnt(0);
            return channel;
        }
    }


}
