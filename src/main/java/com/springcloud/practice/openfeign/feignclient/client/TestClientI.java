package com.springcloud.practice.openfeign.feignclient.client;

import com.springcloud.practice.openfeign.feignclient.config.TestClientConfiguration;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "testClient", url = "http://localhost:9006", configuration = TestClientConfiguration.class)
public interface TestClientI {
    @RequestMapping(
            method= RequestMethod.GET,
            value = "/test/{value}",
            consumes = "application/json")
    Response getValue(
            @PathVariable("value") String value);
}
