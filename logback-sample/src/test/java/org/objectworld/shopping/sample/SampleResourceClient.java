package org.objectworld.shopping.sample;

import org.objectworld.shopping.common.util.RestBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="test-service")
public interface SampleResourceClient {
    @GetMapping(value=RestBase.BASE_URL + "/hello")
    public String hello();
}
