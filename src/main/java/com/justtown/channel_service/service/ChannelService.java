package com.justtown.channel_service.service;

import com.justtown.channel_service.dto.request.GetChannelRequest;
import com.justtown.channel_service.dto.request.SetChannelRequest;
import com.justtown.channel_service.dto.response.AppErrorResponse;
import com.justtown.channel_service.dto.response.GetChannelResponse;
import com.justtown.channel_service.dto.response.SetChannelResponse;
import com.justtown.channel_service.entity.Channel;
import com.justtown.channel_service.repository.ChannelRepository;
import com.justtown.channel_service.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelService {

    private final ChannelRepository repository;
    private final ResponseUtils responseUtils;


    public void updateChannel(Channel channel) {
        repository.save(channel);
    }

    public ResponseEntity<?> getChannel(GetChannelRequest request) {
        Optional<Channel> optional = repository.findByChannelName(request.getChannelName());
        if (optional.isEmpty()) {
            return responseUtils.errorResponse(
                    HttpStatus.NOT_FOUND,
                    String.format("User %s not found", request.getChannelName())
            );
        }
        GetChannelResponse response = new GetChannelResponse(optional.get());
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> setChannel(SetChannelRequest request) {
        Optional<Channel> optional = repository.findByChannelName(request.getChannelName());
        if (optional.isEmpty()) {
            return responseUtils.errorResponse(
                    HttpStatus.NOT_FOUND,
                    String.format("User %s not found", request.getChannelName())
            );
        }
        Channel channel = optional.get();


        if (request.getDisplayName() != null) {
            channel.setDisplayName(request.getDisplayName());
        }
        if (request.getDescription() != null) {
            channel.setDescription(request.getDescription());
        }
        repository.save(channel);
        return ResponseEntity.ok(new SetChannelResponse(true));
    }

    public ResponseEntity<?> getOrCreateCurrentChannel() {
        String channelName = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if (!repository.existsByChannelName(channelName)) {
            Channel channel = Channel.Builder.newChannel(channelName);
            repository.save(channel);
        }
        Optional<Channel> optional = repository.findByChannelName(channelName);
        if (optional.isEmpty()) {
            return responseUtils.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to find nor create a user");
        }
        return ResponseEntity.ok(new GetChannelResponse(optional.get()));
    }
}
