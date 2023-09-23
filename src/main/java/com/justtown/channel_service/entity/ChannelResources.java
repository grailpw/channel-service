package com.justtown.channel_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "t_channel_resources")
public class ChannelResources {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "channel_resource_sequence")
    @SequenceGenerator(name = "channel_resource_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "channelImageURL")
    private String channelImageURL;

    @Column(name = "backgroundImageURL")
    private String backgroundImageURL;

    public class Builer {
        public static ChannelResources newChannelResources() {
            ChannelResources channelResources = new ChannelResources();
            channelResources.setChannelImageURL("TestURL");
            channelResources.setBackgroundImageURL("TestURL");
            return channelResources;
        }
    }

}
