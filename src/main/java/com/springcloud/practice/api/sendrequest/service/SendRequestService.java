package com.springcloud.practice.api.sendrequest.service;

import com.springcloud.practice.openfeign.feignclient.client.TestClientI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendRequestService {

    private final TestClientI testClient;

    public String sendGetValue(String value) throws Exception {
        System.out.println("start");
        String body = testClient.getValue(value).toString();
        System.out.println(body);
        System.out.println("end");
        return body;
    }
}
