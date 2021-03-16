package com.escalade.oc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Class qui permet le lancement et l'injection des dependances de l'application.
 * @author Taeletis
 * 
 */
@ServletComponentScan
@SpringBootApplication
public class SiteEscaladeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteEscaladeApplication.class, args);
		
		
	}


}
