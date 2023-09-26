package com.justtown.channel_service.service;

import com.justtown.channel_service.entity.ChannelResources;
import com.justtown.channel_service.repository.ChannelResourcesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ChannelResourcesService {

    @Autowired
    private final ChannelService channelService;

    @Autowired
    private final ChannelResourcesRepository repository;

    public ChannelResources getChannelResources(String channelName) throws NoSuchElementException {
        return channelService.getChannel(channelName).getChannelResources();
    }

    public void updateChannelProfileImageUUID(String uuid) {
        ChannelResources resources = channelService.getCurrentChannel().getChannelResources();
        resources.setChannelImageUUID(uuid);
        repository.save(resources);
    }

    public void updateChannelBackgroundImageUUID(String uuid) {
        ChannelResources resources = channelService.getCurrentChannel().getChannelResources();
        resources.setBackgroundImageUUID(uuid);
        repository.save(resources);
    }
}
