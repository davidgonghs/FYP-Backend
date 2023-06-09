package com.dghs.fyp.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "test API")
@RestController
public class TestController {

    @ApiOperation(value = "test application Programming interface", notes = "test API")
    @GetMapping("/get")
    public String get(String name) {
        return "Hello World!" + name ;
    }
}
