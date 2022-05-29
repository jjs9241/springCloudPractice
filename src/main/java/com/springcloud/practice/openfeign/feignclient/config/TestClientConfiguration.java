package com.springcloud.practice.openfeign.feignclient.config;

import com.springcloud.practice.openfeign.feignclient.client.TestClientI;
import com.springcloud.practice.openfeign.feignclient.errordecoder.TestErrorDecoder;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class TestClientConfiguration {
//    @Bean
//    public RequestInterceptor requestInterceptor(){
//        return BasicRequestTemplate
//    }

    @Bean
    Request.Options feignOptions() {
        long connectTimeout = 5000;
        TimeUnit connectTimeoutUnit = TimeUnit.MILLISECONDS;
        long readTimeout = 5000;
        TimeUnit readTimeoutUnit = TimeUnit.MILLISECONDS;
        boolean followRedirects = true; // default is true
        return new Request.Options(
                connectTimeout,
                connectTimeoutUnit,
                readTimeout,
                readTimeoutUnit,
                followRedirects);
    }

    @Bean
    Logger feignLogger(){
        return new Slf4jLogger(TestClientI.class);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    ErrorDecoder feignErrorDecoder(){
        return new TestErrorDecoder();
    }

    @Bean
    Retryer feignRetryer(){
        return new Retryer.Default();
    }

    @Bean
    Encoder feignEncoder(){
        return new GsonEncoder();
    }

    @Bean
    Decoder feignDecoder(){
        return new GsonDecoder();
    }

//    @Bean
//    public Feign.Builder feignBuilder(){
//        long connectTimeout = 5000;
//        TimeUnit connectTimeoutUnit = TimeUnit.MILLISECONDS;
//        long readTimeout = 5000;
//        TimeUnit readTimeoutUnit = TimeUnit.MILLISECONDS;
//        boolean followRedirects = true; // default is true
//        return Feign.builder()
//                .options(new Request.Options(
//                        connectTimeout,
//                        connectTimeoutUnit,
//                        readTimeout,
//                        readTimeoutUnit,
//                        followRedirects))
//                .logger(new Slf4jLogger(TestClientI.class))
//                .logLevel(Logger.Level.FULL)
//                .errorDecoder(new TestErrorDecoder())
//                //.retryer()
//                .encoder(new GsonEncoder())
//                .decoder(new GsonDecoder())
//                ;
//    }
}
