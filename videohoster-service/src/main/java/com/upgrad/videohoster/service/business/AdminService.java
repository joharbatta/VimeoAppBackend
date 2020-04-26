package com.upgrad.videohoster.service.business;


import com.upgrad.videohoster.service.dao.VideoDao;
import com.upgrad.videohoster.service.entity.VideoEntity;
import com.upgrad.videohoster.service.entity.UserAuthTokenEntity;
import com.upgrad.videohoster.service.exception.VideoNotFoundException;
import com.upgrad.videohoster.service.exception.UnauthorizedException;
import com.upgrad.videohoster.service.exception.UserNotSignedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Autowired
    private VideoDao videoDao;

    public VideoEntity getVideo(final String videoUuid, final String authorization) throws VideoNotFoundException, UnauthorizedException, UserNotSignedInException {

        UserAuthTokenEntity userAuthTokenEntity = videoDao.getUserAuthToken(authorization);
        if (userAuthTokenEntity == null) {
            throw new UserNotSignedInException("USR-001", "You are not Signed in, sign in first to get the details of the image");
        }

        String role = userAuthTokenEntity.getUser().getRole();
        if (role.equals("admin")) {
            VideoEntity videoEntity = videoDao.getVideo(videoUuid);
            if (videoEntity == null) {
                throw new VideoNotFoundException("VID-001", "Video with Uuid not found");
            }
            return videoEntity;
        } else
            throw new UnauthorizedException("ATH-001", "UNAUTHORIZED Access, Entered user is not an admin");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public VideoEntity updateVideo(final VideoEntity videoEntity, final String authorization) throws VideoNotFoundException, UnauthorizedException, UserNotSignedInException {
        UserAuthTokenEntity userAuthTokenEntity = videoDao.getUserAuthToken(authorization);
        if (userAuthTokenEntity == null) {
            throw new UserNotSignedInException("USR-001", "You are not Signed in, sign in first to update the details of the image");
        }
        String role = userAuthTokenEntity.getUser().getRole();
        if (role.equals("admin")) {

            VideoEntity existingvideoEntity = videoDao.getVideoById(videoEntity.getId());

            if (existingvideoEntity == null) {
                throw new VideoNotFoundException("VID-002", "Video with given id is not found");
            }

            videoEntity.setUuid(existingvideoEntity.getUuid());
            videoEntity.setNo_of_likes(existingvideoEntity.getNo_of_likes());
            videoEntity.setUser_id(existingvideoEntity.getUser_id());
            videoEntity.setCreated_at(existingvideoEntity.getCreated_at());

            return videoDao.updateVideo(videoEntity);
        } else {
            throw new UnauthorizedException("ATH-001", "Unauthorized Access, Entered user is not an admin");
        }
    }
}