package com.upgrad.videohoster.api.controller;


import com.upgrad.videohoster.service.exception.UploadFailedException;
import com.upgrad.videohoster.api.model.VideoUploadRequest;
import com.upgrad.videohoster.api.model.VideoUploadResponse;
import com.upgrad.videohoster.service.business.VideoUploadService;
import com.upgrad.videohoster.service.entity.VideoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.UUID;
@RestController
@RequestMapping("/")
public class VideoUploadController {

    @Autowired
    private VideoUploadService videoUploadService;
    //video upload
    @RequestMapping(method = RequestMethod.POST, path = "/videoupload", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VideoUploadResponse> videoupload(final VideoUploadRequest videoUploadRequest, @RequestHeader("authorization") final String authorization) throws UploadFailedException{

        // Adds all the attributes provided to the video entity
        final VideoEntity videoEntity = new VideoEntity();
        videoEntity.setVideo(videoUploadRequest.getVideo());
        videoEntity.setName(videoUploadRequest.getName());
        videoEntity.setDescription(videoUploadRequest.getDescription());
        videoEntity.setUuid(UUID.randomUUID().toString());
        videoEntity.setNo_of_likes(0);
        videoEntity.setCreated_at(ZonedDateTime.now());
        videoEntity.setStatus("REGISTERED");

        // Calls the upload method of videoUploadService with the provided attributes
        final VideoEntity createdvideoEntity = videoUploadService.upload(videoEntity, authorization);

        // Loads the VideoUploadResponse with the uuid of the new user created and the respective status message
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse().id(createdvideoEntity.getUuid()).status("Video Successfully Uploaded");

        // Returns the VideoUploadResponse with resource created http status
        return new ResponseEntity<VideoUploadResponse>(videoUploadResponse, HttpStatus.CREATED);
    }
}