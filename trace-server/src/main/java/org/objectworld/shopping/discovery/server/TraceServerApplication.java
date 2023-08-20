package org.objectworld.shopping.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class TraceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraceServerApplication.class, args);
    }
}
