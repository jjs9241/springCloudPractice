package com.springcloud.practice.api.sendrequest.service;

import com.springcloud.practice.openfeign.feignclient.client.TestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendRequestService {

    private final TestClient testClient;

    public String sendGetValue(String value) throws Exception {
        System.out.println("start");
        String body = testClient.getValue(value).getBody();
        System.out.println("end");
        return body;
    }

    public String getRst() throws Exception {
        return "rst";
    }
}
