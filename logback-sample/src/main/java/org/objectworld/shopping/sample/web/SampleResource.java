package org.objectworld.shopping.sample.web;

import org.objectworld.shopping.common.util.RestBase;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RestController
@RequestMapping(RestBase.BASE_URL + "/hello")
public class SampleResource {
    @GetMapping
    public String hello() {
    	log.warn("==> hello ");
    	log.info("==> hello ");
    	log.info("==> hello ");
    	log.debug("==> hello ");
    	log.trace("==> hello ");
    	log.error("Exception occured", new Exception());
        return "Hello";
    }
}
