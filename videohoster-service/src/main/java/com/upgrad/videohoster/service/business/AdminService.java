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
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public VideoEntity updateVideo(final VideoEntity videoEntity, final String authorization) throws VideoNotFoundException, UnauthorizedException, UserNotSignedInException {
        UserAuthTokenEntity userAuthTokenEntity = videoDao.getUserAuthToken(authorization);

        String role = userAuthTokenEntity.getUser().getRole();
    }
}
