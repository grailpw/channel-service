package com.justtown.channel_service.controller;

import com.justtown.channel_service.dto.request.channel_resources.GetChannelResourcesRequest;
import com.justtown.channel_service.dto.request.channel_resources.UpdateChannelBackgroundImageRequest;
import com.justtown.channel_service.dto.request.channel_resources.UpdateChannelProfileImageRequest;
import com.justtown.channel_service.dto.response.channel_resources.GetChannelResourcesResponse;
import com.justtown.channel_service.dto.response.channel_resources.UpdateChannelBackgroundImageResponse;
import com.justtown.channel_service.dto.response.channel_resources.UpdateChannelProfileImageResponse;
import com.justtown.channel_service.entity.ChannelResources;
import com.justtown.channel_service.service.ChannelResourcesService;
import com.justtown.channel_service.service.MinioService;
import io.minio.errors.MinioException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/channel/resources")
@RequiredArgsConstructor
public class ChannelResourcesController {

    @Autowired
    private final ChannelResourcesService channelResourcesService;
    @Autowired
    private final MinioService minioService;

    @GetMapping
    public ResponseEntity<?> getChannelResources(@RequestBody GetChannelResourcesRequest request) {
        try {
            ChannelResources resources = channelResourcesService.getChannelResources(request.getChannelName());
            GetChannelResourcesResponse response = new GetChannelResourcesResponse();
            response.setProfileImageURL(
                    minioService.generateGetURL(String.format("%s.webp", resources.getChannelImageUUID()))
            );
            response.setBackgroundImageURL(
                    minioService.generateGetURL(String.format("%s.webp", resources.getBackgroundImageUUID()))
            );
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/get-update-profile-image-link")
    public ResponseEntity<?> getUpdateProfileImageLink(@RequestBody UpdateChannelProfileImageRequest request) {
        String uuid = UUID.randomUUID().toString();
        try {
            String postURL = minioService.generatePostURL(String.format("%s.%s", uuid, request.getFileExtension()));
            channelResourcesService.updateChannelProfileImageUUID(uuid);
            UpdateChannelProfileImageResponse response = new UpdateChannelProfileImageResponse(postURL);
            return ResponseEntity.ok(response);
        } catch (MinioException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/get-update-background-image-link")
    public ResponseEntity<?> getUpdateBackgroundImageLink(@RequestBody UpdateChannelBackgroundImageRequest request) {
        String uuid = UUID.randomUUID().toString();
        try {
            String postURL = minioService.generatePostURL(String.format("%s.%s", uuid, request.getFileExtension()));
            channelResourcesService.updateChannelBackgroundImageUUID(uuid);
            UpdateChannelBackgroundImageResponse response = new UpdateChannelBackgroundImageResponse(postURL);
            return ResponseEntity.ok(response);
        } catch (MinioException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}

