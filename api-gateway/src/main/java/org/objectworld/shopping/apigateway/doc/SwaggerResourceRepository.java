package org.objectworld.shopping.apigateway.doc;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class SwaggerResourceRepository {
	private final ConcurrentHashMap<String, String> swaggrResourceMap;
	
	public SwaggerResourceRepository() {
		this.swaggrResourceMap = new ConcurrentHashMap<String,String>();
	}
	
	public void addSwaggerResource(String name, String content) {
		swaggrResourceMap.put(name, content);
	}
	
	public String getSwaggerResource(String serviceName) {
		return swaggrResourceMap.get(serviceName);
	}
}
