package com.upgrad.videohoster.service.business;

import com.upgrad.videohoster.service.dao.VideoDao;
import com.upgrad.videohoster.service.entity.VideoEntity;
import com.upgrad.videohoster.service.entity.UserAuthTokenEntity;
import com.upgrad.videohoster.service.exception.UploadFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VideoUploadService {

    @Autowired
    private VideoDao videoDao;
    //upload video
    @Transactional(propagation = Propagation.REQUIRED)
    public VideoEntity upload(VideoEntity videoEntity, final String authorizationToken) throws UploadFailedException {

        //getUserAuthToken() in video dao will verify if token exist
        UserAuthTokenEntity userAuthTokenEntity = videoDao.getUserAuthToken(authorizationToken);
        if (userAuthTokenEntity == null) {
            //exception
            throw new UploadFailedException("UP-001", "User is not Signed in, sign in to upload an video");
        }
        videoEntity.setUser_id(userAuthTokenEntity.getUser());
        //create video in video dao will persist video entity
        return videoDao.createVideo(videoEntity);
    }
}