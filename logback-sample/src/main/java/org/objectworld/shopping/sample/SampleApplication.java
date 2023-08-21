package org.objectworld.shopping.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("org.objectworld.shopping")
public class SampleApplication {

	public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
	}
}
