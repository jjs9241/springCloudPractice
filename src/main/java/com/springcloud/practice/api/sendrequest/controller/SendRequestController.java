package com.springcloud.practice.api.sendrequest.controller;

import com.springcloud.practice.api.sendrequest.service.SendRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendRequestController {

    //@Autowired
    SendRequestService sendRequestService;

    @GetMapping(value = "/get_value/{value}")
    public ResponseEntity<String> testGetValue (
            @PathVariable String value) throws Exception {
        System.out.println("start");
        String rst = sendRequestService.sendGetValue(value);
        System.out.println("end");
        return new ResponseEntity<>(
                rst,
                HttpStatus.OK);
    }
}
