package com.springcloud.practice.openfeign.feignclient.errordecoder;

import feign.Response;
import feign.codec.ErrorDecoder;

public class TestErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response){
        System.out.println(response.toString());

        if (400 == response.status()) {
            System.out.println("It's a 400 Error!!!");
        }

        return defaultErrorDecoder.decode(methodKey, response);
    }
}
