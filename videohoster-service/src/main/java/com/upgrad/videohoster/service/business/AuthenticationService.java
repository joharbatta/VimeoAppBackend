package com.upgrad.videohoster.service.business;


import com.upgrad.videohoster.service.dao.UserDao;
import com.upgrad.videohoster.service.entity.UserAuthTokenEntity;
import com.upgrad.videohoster.service.entity.UserEntity;
import com.upgrad.videohoster.service.exception.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
public class AuthenticationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider CryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserAuthTokenEntity authenticate(final String username, final String password) throws AuthenticationFailedException {

        //Call the getUserByEmail() method in UserDao class for UserDao object and pass email as argument
        // Receive the value returned by  getUserByEmail() method in userEntity type object

        UserEntity userEntity = userDao.getUserByEmail(username);
        if (userEntity == null) {
            throw new AuthenticationFailedException("ATH-001", "User with email not found");
        }
        //After that you have got userEntity from user table, we need to compare the password entered by the user
        // with the password stored in the database
        //Since the password stored in the database is encrypted, so we also encrypt the password entered by the customer
        // using the Salt attribute in the database
        //Call the encrypt() method in PasswordCryptographyProvider class for CryptographyProvider object

        final String encryptedPassword = CryptographyProvider.encrypt(password, userEntity.getSalt());

        //Now encryptedPassword contains the password entered by the customer in encrypted form
        //And userEntity.getPassword() gives the password stored in the database in encrypted form
        //We compare both the passwords

        if (encryptedPassword.equals(userEntity.getPassword())) {

            //Implementation of JwtTokenProvider class
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(encryptedPassword);
            //Now UserAuthTokenEntity type object is to be persisted in a database
            //Declaring an object userAuthTokenEntity of type UserAuthTokenEntity and setting its attributes
            UserAuthTokenEntity userAuthTokenEntity = new UserAuthTokenEntity();
            userAuthTokenEntity.setUser(userEntity);
            final ZonedDateTime now = ZonedDateTime.now();
            final ZonedDateTime expiresAt = now.plusHours(8);

            userAuthTokenEntity.setAccessToken(jwtTokenProvider.generateToken(userEntity.getUuid(), now, expiresAt));

            userAuthTokenEntity.setLoginAt(now);
            userAuthTokenEntity.setExpiresAt(expiresAt);

            //Call the createAuthToken() method in UserDao
            //Pass uerAuthTokenEntity as an argument
            userDao.createAuthToken(userAuthTokenEntity);

            //updateUser() method in userDao class calls the merge() method to update the userEntity
            userDao.updateUser(userEntity);
            userEntity.setLastLoginAt(now);
            return userAuthTokenEntity;
        }
        else {
            //throw exception
            throw new AuthenticationFailedException("ATH-002", "Password failed");
        }
    }
}


