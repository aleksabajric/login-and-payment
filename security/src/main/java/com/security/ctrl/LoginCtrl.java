package com.security.ctrl;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoginCtrl {
    private static final Logger logger = LoggerFactory.getLogger(LoginCtrl.class);

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        logger.info(String.format("User :" + principal.getName()));
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

}
