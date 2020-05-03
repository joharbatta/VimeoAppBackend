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
    // Signup endpoint requests for all the attributes in “SignupUserRequest” about the user and registers a user successfully.
    @RequestMapping(method = RequestMethod.POST, path = "/usersignup", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SignupUserResponse> userSignup(final SignupUserRequest signupUserRequest) {

        final UserEntity userEntity = new UserEntity();

        // Adds all the attributes provided to the userentity
        userEntity.setUuid(UUID.randomUUID().toString());
        userEntity.setFirstName(signupUserRequest.getFirstName());
        userEntity.setLastName(signupUserRequest.getLastName());
        userEntity.setEmail(signupUserRequest.getEmailAddress());
        userEntity.setPassword(signupUserRequest.getPassword());
        userEntity.setMobilePhone(signupUserRequest.getMobileNumber());
        userEntity.setSalt("1234abc");
        userEntity.setRole("nonadmin");

        // Calls the signup method of signupBusinessservice with the provided attributes
        final UserEntity createdUserEntity = signupBusinessService.signup(userEntity);

        // Loads the SignupUserResponse with the uuid of the new user created and the respective status message
        SignupUserResponse userResponse = new SignupUserResponse().id(createdUserEntity.getUuid()).status("USER SUCCESSFULLY REGISTERED");

        // Returns the SignupuserResponse with resource created http status
        return new ResponseEntity<SignupUserResponse>(userResponse, HttpStatus.CREATED);
    }
}
