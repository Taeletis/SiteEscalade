package com.escalade.oc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Class qui permet le lancement et l'injection des dependances de l'application.
 * @author Taeletis
 * 
 */
@ServletComponentScan
@SpringBootApplication
public class SiteEscaladeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SiteEscaladeApplication.class, args);
		
		
	}

	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(SiteEscaladeApplication.class);
	  }
}
