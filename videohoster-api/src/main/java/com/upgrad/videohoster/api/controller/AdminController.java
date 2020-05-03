package com.upgrad.videohoster.api.controller;


import com.upgrad.videohoster.api.model.UpdateVideoRequest;
import com.upgrad.videohoster.api.model.UpdateVideoResponse;
import com.upgrad.videohoster.api.model.VideoDetailsResponse;
import com.upgrad.videohoster.service.business.AdminService;


import com.upgrad.videohoster.service.entity.VideoEntity;
import com.upgrad.videohoster.service.exception.UnauthorizedException;
import com.upgrad.videohoster.service.exception.UserNotSignedInException;
import com.upgrad.videohoster.service.exception.VideoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;
    //get video by id
    @RequestMapping(method = RequestMethod.GET, path = "/videos/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VideoDetailsResponse> getVideo(@PathVariable("id") final String videoUuid, @RequestHeader("authorization") final String authorization) throws VideoNotFoundException, UnauthorizedException, UserNotSignedInException {

        //will send video id and access token to get video() method in adminservice it will return video entity if exist
        final VideoEntity videoEntity = adminService.getVideo(videoUuid, authorization);

        //setting video entity details in details response object
        VideoDetailsResponse videoDetailsResponse = new VideoDetailsResponse().
                video(videoEntity.getVideo()).id((int) videoEntity.getId())
                .name(videoEntity.getName()).description(videoEntity.getDescription())
                .status(videoEntity.getStatus());

        // Returns the VideoDetailsResponse with  http status
        return new ResponseEntity<VideoDetailsResponse>(videoDetailsResponse, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/videos/update/{video_id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UpdateVideoResponse> updateVideo(final UpdateVideoRequest updateVideoRequest, @PathVariable("video_id") final long video_id, @RequestHeader("authorization") final String authorization) throws VideoNotFoundException, UnauthorizedException, UserNotSignedInException {
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setVideo(updateVideoRequest.getVideo());
        videoEntity.setId(video_id);
        videoEntity.setName(updateVideoRequest.getName());
        videoEntity.setStatus(updateVideoRequest.getStatus());
        videoEntity.setDescription(updateVideoRequest.getDescription());
        VideoEntity updatedvideoEntity = adminService.updateVideo(videoEntity, authorization);
        UpdateVideoResponse updateVideoResponse = new UpdateVideoResponse().id((int) updatedvideoEntity.getId()).status(updatedvideoEntity.getStatus());
        return new ResponseEntity<UpdateVideoResponse>(updateVideoResponse, HttpStatus.OK);
    }


}