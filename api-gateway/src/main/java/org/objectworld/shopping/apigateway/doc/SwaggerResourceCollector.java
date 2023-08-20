package org.objectworld.shopping.apigateway.doc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SwaggerResourceCollector {
	@Autowired
	private RouteLocator routeLocator;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private SwaggerResourceRepository swaggerResourceRepository;
	
//	@Scheduled(
//			initialDelayString = "${swagger.collector.initial-delay}", 
//			fixedDelayString = "${swagger.collector.interval}"
//	)
//	public void collect() {
//		log.trace("===== Routes =====");
//		Iterator<Route> it = routeLocator.getRoutes().toStream().iterator();
//		while(it.hasNext()) {
//			Route route = it.next();
//			log.trace("Route = {}", route);
//		}
//		
//		log.info("===== Reload api-doc of services in the Eureka registry =====");
//		discoveryClient.getServices().stream().forEach(serviceId -> {
//			List<ServiceInstance> serviceInstances = 
//					discoveryClient.getInstances(serviceId);
//			log.debug("      serviceName={}", serviceId);
//			if (serviceInstances == null || serviceInstances.isEmpty()) { 
//				log.warn("No instances available for service : {} ", serviceId);
//			} else {
//				ServiceInstance instance = serviceInstances.get(0);
//				String swaggerUrl = instance.getUri()+"/v2/api-docs/";
//				HashMap jsonData = WebClient.create(swaggerUrl)
//						.method(HttpMethod.GET)
//						.retrieve()
//						.bodyToMono(HashMap.class)
//						.block();
//				String content = getJson(serviceId, jsonData);
//				if(log.isTraceEnabled()) {
//					log.trace("      swagger={}", jsonData);
//				}
//				swaggerResourceRepository.addSwaggerResource(serviceId, content);
//			}
//		});
//	}

	public String getJson(String serviceId, Object jsonData) {
		try {
			return new ObjectMapper().writeValueAsString(jsonData);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
}
