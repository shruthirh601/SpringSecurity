package com.shruthi.SpringSecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello/and")
    public String hello(Authentication authentication) {
        logger.info("logs from heloo"+authentication.toString());
        return String.format("Hello, %s!", authentication.getName() + " " + authentication.isAuthenticated());
    }

    @GetMapping("/public/hello")
    public String publicHello() { return "hello public"; }

    @GetMapping("/user/hello")
    public String userHello() { return "hello user"; }

    @GetMapping("/admin/hello")
    public String adminHello() { return "hello admin"; }

}
