package com.justtown.channel_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "t_channel_resources")
public class ChannelResources {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "channel_resource_sequence")
    @SequenceGenerator(name = "channel_resource_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "channelImageUUID")
    private String channelImageUUID;

    @Column(name = "backgroundImageUUID")
    private String backgroundImageUUID;

    public static class Builder {
        public static ChannelResources newChannelResources() {
            ChannelResources channelResources = new ChannelResources();
            channelResources.setChannelImageUUID(UUID.randomUUID().toString());
            channelResources.setBackgroundImageUUID(UUID.randomUUID().toString());
            return channelResources;
        }
    }
}