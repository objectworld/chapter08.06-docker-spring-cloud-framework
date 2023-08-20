package org.objectworld.shopping.discovery.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@ComponentScan("org.objectworld")
@Slf4j
public class EurekaApplicationTests {
	@Value("${spring.application.name}")
	String applicationName;
	
	@Test
	public void getName() {
		log.info("applicationName={}", applicationName);
		Assertions.assertEquals("discovery-service", applicationName);		
	}
}
