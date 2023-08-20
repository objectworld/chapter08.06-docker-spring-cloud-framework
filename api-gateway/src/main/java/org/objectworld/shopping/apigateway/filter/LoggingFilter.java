package org.objectworld.shopping.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {

    public LoggingFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // Pre Filter
            if(config.isLogRequest()){
                log.info("==> id={}, path={}, uri={}", 
                		request.getId(), request.getPath(), request.getURI());
            }

            log.info("    message={}", config.getMessage());

            return chain.filter(exchange).then(Mono.fromRunnable(() ->
            {
                // Post Filter
                if(config.isLogResponse()){
                    log.info("<== id={}, responseCode={}, uri={}", 
                    		request.getId(), response.getStatusCode(), request.getURI());
                }
            }));
        }, Ordered.LOWEST_PRECEDENCE);

        return filter;
    }

    @Getter
    @Setter
    public static class Config {
        // Filter Parameter Definition
        private String message;
        private boolean logRequest;  
        private boolean logResponse;
    }
}