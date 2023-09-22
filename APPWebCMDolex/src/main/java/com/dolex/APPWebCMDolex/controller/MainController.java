package com.dolex.APPWebCMDolex.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public Object main(OAuth2AuthenticationToken token) {
        System.out.println(token.getPrincipal());
        return "templates/main.html";
    }
}
