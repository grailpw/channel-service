package com.justtown.channel_service.controller;

import com.justtown.channel_service.dto.request.SetChannelRequest;
import com.justtown.channel_service.dto.request.GetChannelRequest;
import com.justtown.channel_service.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping("/get-channel")
    public ResponseEntity<?> getChannel(@RequestBody GetChannelRequest request) {
        return channelService.getChannel(request);
    }

    @PostMapping("/get-or-create-current-channel")
    public ResponseEntity<?> createChannel() {
        return channelService.getOrCreateCurrentChannel();
    }

    @PutMapping("/set-channel")
    public ResponseEntity<?> setChannel(@RequestBody SetChannelRequest request) {
        return channelService.setChannel(request);
    }

}
