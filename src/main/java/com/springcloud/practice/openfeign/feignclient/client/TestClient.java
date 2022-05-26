package com.springcloud.practice.openfeign.feignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "testClient", url = "http://localhost:9006")
public interface TestClient {
    @RequestMapping(
            method= RequestMethod.GET,
            value = "/test")
    ResponseEntity<String> getValue(
            @PathVariable("value") String value);
}
