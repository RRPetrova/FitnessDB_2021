package com.example.fitnessdb.web.listener;

import com.example.fitnessdb.service.LoggerService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;


@Component
public class RegistrationListener {

    private final LoggerService loggerService;

    public RegistrationListener(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @EventListener(UserEvent.class)
    public void onApplicationEvent(UserEvent event) {
        System.out.println("User registration success");
        System.out.println("User "+ event.getUsername() + " registered!");
        this.loggerService.log(event);
    }


}
