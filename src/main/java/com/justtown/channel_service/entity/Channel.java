package com.justtown.channel_service.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(cascade = CascadeType.ALL)
    private ChannelDetails channelDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private ChannelResources channelResources;

    public static class Builder {
        public static Channel newChannel(String channelName) {
            Channel channel = new Channel();
            channel.setChannelName(channelName);
            channel.setDisplayName(channelName);
            channel.setDescription("Empty description");
            channel.setChannelDetails(ChannelDetails.Builder.newChannelDetails());
            channel.setChannelResources(ChannelResources.Builder.newChannelResources());
            return channel;
        }
    }


}
