package org.objectworld.shopping.apigateway;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ApiGatewayApplicationTest {
	@Value("${spring.application.name}")
	String applicationName;

	@Autowired
	private WebTestClient client;
	
//	@LocalServerPort
//	int port;
//	private WebTestClient client;
//	
//	@BeforeEach
//	public void setup() {
//		client = WebTestClient.bindToServer()
//				.baseUrl("http://localhost:" + port).build();
//	}

	@Test
	public void getName() {
		log.info("applicationName={}", applicationName);
		Assertions.assertEquals("gateway-service", applicationName);		
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void route() {
		client.get().uri("/test")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.consumeWith(result -> {
				assertThat(result.getResponseBody()).isNotEmpty();
			});
	}
}
