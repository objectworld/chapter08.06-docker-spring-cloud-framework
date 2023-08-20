package org.objectworld.shopping.apigateway.filter;

import java.security.Principal;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class AuditGlobalFilterConfiguration {

    @Bean
    public GlobalFilter auditFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("=== [AuditFilter] id={}, path={}, uri={}, method={} ===", 
            		request.getId(), request.getPath(), 
            		request.getURI(), request.getMethod());
            return chain.filter(exchange);
        };
    }
}