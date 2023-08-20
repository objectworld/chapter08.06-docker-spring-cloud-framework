package org.objectworld.shopping.apigateway.doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SwaggerResourceController {
	
	@Autowired
	SwaggerResourceRepository swaggerResourceRepository;
	
	@GetMapping("/service/{serviceName}")
	public String getServiceDefinition(@PathVariable("serviceName") String serviceName) {
		return swaggerResourceRepository.getSwaggerResource(serviceName);
	}
}
