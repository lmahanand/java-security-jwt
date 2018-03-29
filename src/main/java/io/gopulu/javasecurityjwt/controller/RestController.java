package io.gopulu.javasecurityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lingrajmahanand on 3/28/18.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/app")
public class RestController {
    @GetMapping
    public String serverStatus(){
        return "JWT secured resource!";
    }
}
