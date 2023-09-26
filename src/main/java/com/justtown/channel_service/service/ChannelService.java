package com.justtown.channel_service.service;

import com.justtown.channel_service.dto.request.channel.UpdateChannelRequest;
import com.justtown.channel_service.entity.Channel;
import com.justtown.channel_service.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ChannelService {

    @Autowired
    private final ChannelRepository repository;

    public Channel getChannel(String channelName) throws NoSuchElementException {
        return repository.findByChannelName(channelName).orElseThrow();
    }

    public Channel updateChannel(@Param("request") UpdateChannelRequest request) {
        Channel channel = getCurrentChannel();
        if (request.getDisplayName() != null) {
            channel.setDisplayName(request.getDisplayName());
        }
        if (request.getDescription() != null) {
            channel.setDescription(request.getDescription());
        }
        repository.save(channel);
        return channel;
    }

    public Channel getCurrentChannel() {
        String channelName = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if (!repository.existsByChannelName(channelName)) {
            Channel channel = Channel.Builder.newChannel(channelName);
            repository.save(channel);
        }
        return repository.findByChannelName(channelName).orElseThrow();
    }

}
