package com.victor.springsecurityclient.entity.listener;

import com.victor.springsecurityclient.entity.User;
import com.victor.springsecurityclient.event.RegistrationCompleteEvent;
import com.victor.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the Verification Token for the User with link

        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //Send Mail to User
        String url = event.getApplicationUrl()+ "/verifyRegistration?token="+token;
        //send verificationEmail(
        log.info("Click the link to verify your account:  {}", url);
    }
}
