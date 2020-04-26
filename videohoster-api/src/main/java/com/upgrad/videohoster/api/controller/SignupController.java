package com.upgrad.videohoster.api.controller;

import com.upgrad.videohoster.api.model.SignupUserRequest;
import com.upgrad.videohoster.api.model.SignupUserResponse;
import com.upgrad.videohoster.service.business.SignupBusinessService;
import com.upgrad.videohoster.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@RequestMapping("/")
public class SignupController {

    @Autowired
    private SignupBusinessService signupBusinessService;

    @RequestMapping(method = RequestMethod.POST, path = "/usersignup", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SignupUserResponse> userSignup(final SignupUserRequest signupUserRequest) {

        final UserEntity userEntity = new UserEntity();

        userEntity.setUuid(UUID.randomUUID().toString());
        userEntity.setFirstName(signupUserRequest.getFirstName());
        userEntity.setLastName(signupUserRequest.getLastName());
        userEntity.setEmail(signupUserRequest.getEmailAddress());
        userEntity.setPassword(signupUserRequest.getPassword());
        userEntity.setMobilePhone(signupUserRequest.getMobileNumber());
        userEntity.setSalt("1234abc");
        userEntity.setRole("nonadmin");

        final UserEntity createdUserEntity = signupBusinessService.signup(userEntity);
        SignupUserResponse userResponse = new SignupUserResponse().id(createdUserEntity.getUuid()).status("USER SUCCESSFULLY REGISTERED");
        return new ResponseEntity<SignupUserResponse>(userResponse, HttpStatus.CREATED);
    }
}

67b6f124-c357-45a6-b987-31c6fcbe388d
        eyJraWQiOiJhYzljYWJhNi0wNzNiLTQwY2ItYjVjZi02NDNlOGRiMzhlYzkiLCJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJjYWJiODA0Yi02YjU0LTQ3ODQtOWFkZi1iM2JhZGRkZWNkYTciLCJpc3MiOiJodHRwczovL3Byb21hbi5pbyIsImV4cCI6MTU4NzkyMSwiaWF0IjoxNTg3ODkyfQ.hy6y_ZVuQCk9_2YADwfOhVxrqJZJKrU110_Q1J8UcD8Zn8VgNOaOPmNI8d6PRAJnR118BAA2eYLTxZhfWbR-FA