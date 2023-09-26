package com.justtown.channel_service.controller;

import com.justtown.channel_service.dto.request.channel_details.GetChannelDetailsRequest;
import com.justtown.channel_service.dto.response.channel_details.GetChannelDetailsResponse;
import com.justtown.channel_service.entity.ChannelDetails;
import com.justtown.channel_service.service.ChannelDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/channel/details")
@RequiredArgsConstructor
public class ChannelDetailsController {

    private final ChannelDetailsService channelDetailsService;

    @GetMapping
    public ResponseEntity<?> getChannelDetails(@RequestBody GetChannelDetailsRequest request) {
        try {
            ChannelDetails channelDetails = channelDetailsService.getChannelDetails(request.getChannelName());
            GetChannelDetailsResponse response = new GetChannelDetailsResponse(channelDetails);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
