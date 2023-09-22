package com.dolex.APPWebCMDolex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppWebCmDolexApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AppWebCmDolexApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppWebCmDolexApplication.class);
	}

}
