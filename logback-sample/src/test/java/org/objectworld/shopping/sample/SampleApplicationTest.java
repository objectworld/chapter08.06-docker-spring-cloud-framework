package org.objectworld.shopping.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@EnableFeignClients
public class SampleApplicationTest {
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Autowired
	SampleResourceClient client;
	
	@Test
	@Order(1)
	public void getName() {
		log.info("applicationName={}", applicationName);
		Assertions.assertEquals("test-service", applicationName);		
	}
	
	@Test
	@Order(2)
	public void hello() {
		log.info("Start Test");
		
		try {
			String result = client.hello();
			log.info("result={}", result);
			Assertions.assertEquals("Hello", result);
		} catch(Exception e) {
			log.error("Exception : ", e);
			Assertions.fail(e);
		}
	}
}
