package com.justtown.channel_service.service;

import com.justtown.channel_service.entity.ChannelDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ChannelDetailsService {

    private final ChannelService channelService;

    public ChannelDetails getChannelDetails(String channelName) throws NoSuchElementException {
        return channelService.getChannel(channelName).getChannelDetails();
    }
}
