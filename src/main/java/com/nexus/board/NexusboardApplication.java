package com.nexus.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NexusboardApplication {

	public static void main(String[] args) {
		//System.setProperties("spring.devtools.restart.enabled", "false");
		//System.setProperties("spring.devtools.livereload.enabled", "true");
		SpringApplication.run(NexusboardApplication.class, args);
	}

}
