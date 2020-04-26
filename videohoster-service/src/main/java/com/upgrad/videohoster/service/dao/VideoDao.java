package com.upgrad.videohoster.service.dao;

import com.upgrad.videohoster.service.entity.VideoEntity;
import com.upgrad.videohoster.service.entity.UserAuthTokenEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class VideoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public VideoEntity createVideo(VideoEntity videoEntity) {
        entityManager.persist(videoEntity);
        return videoEntity;
    }

    public UserAuthTokenEntity getUserAuthToken(final String accesstoken) {
        try {
            return entityManager.createNamedQuery("userAuthTokenByAccessToken", UserAuthTokenEntity.class).setParameter("accessToken", accesstoken).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public VideoEntity getVideo(final String videoUuid) {

        try {
            return entityManager.createNamedQuery("VideoEntityByUuid", VideoEntity.class).setParameter("uuid", videoUuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
//
//    public VideoEntity getVideoById(final long Id) {
//    }
//
//    public VideoEntity updateVideo(final VideoEntity videoEntity) {
//        return entityManager.merge(videoEntity);
//    }
}
