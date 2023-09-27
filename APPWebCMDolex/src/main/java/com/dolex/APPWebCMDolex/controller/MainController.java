package com.dolex.APPWebCMDolex.controller;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> develop
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

<<<<<<< HEAD
    @GetMapping("/")
    public Object main(OAuth2AuthenticationToken token) {
        System.out.println(token.getPrincipal());
        return "templates/main.html";
    }
=======
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/")
    public String bienvenida(OAuth2AuthenticationToken token) {
        
        request.setAttribute("login", token.getPrincipal().getAttributes().get("login"));
        request.setAttribute("avatar", token.getPrincipal().getAttributes().get("avatar_url"));
        
        return "bienvenida";
    }
	
	@GetMapping("/citas")
    public String citas() {
        return "consulta_citas";
    }
	
	@GetMapping("/registroCitas")
    public String registroCitas() {
        return "registro_citas";
    }
	
>>>>>>> develop
}
