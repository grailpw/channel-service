package com.justtown.channel_service.controller;

import com.justtown.channel_service.dto.request.channel.GetChannelRequest;
import com.justtown.channel_service.dto.request.channel.UpdateChannelRequest;
import com.justtown.channel_service.dto.response.channel.GetChannelResponse;
import com.justtown.channel_service.entity.Channel;
import com.justtown.channel_service.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("api/v1/channel")
@RequiredArgsConstructor
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public ResponseEntity<?> getChannel(@RequestBody GetChannelRequest request) {
        try {
            Channel channel = channelService.getChannel(request.getChannelName());
            GetChannelResponse response = new GetChannelResponse(channel);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/current")
    public ResponseEntity<?> getOrCreateCurrentChannel() {
        Channel channel = channelService.getCurrentChannel();
        GetChannelResponse response = new GetChannelResponse(channel);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<?> updateChannel(@RequestBody UpdateChannelRequest request) {
        try {
            Channel channel = channelService.updateChannel(request);
            GetChannelResponse response = new GetChannelResponse(channel);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
