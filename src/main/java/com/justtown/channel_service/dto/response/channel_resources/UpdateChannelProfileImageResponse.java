package com.justtown.channel_service.dto.response.channel_resources;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateChannelProfileImageResponse {
    private String uploadUrl;
}
