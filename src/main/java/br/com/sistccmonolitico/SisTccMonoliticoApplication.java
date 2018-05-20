package br.com.sistccmonolitico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SisTccMonoliticoApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SisTccMonoliticoApplication.class);
    }
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SisTccMonoliticoApplication.class, args);
	}
}
