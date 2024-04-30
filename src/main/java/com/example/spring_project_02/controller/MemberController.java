package com.example.spring_project_02.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public void login() {
        log.info("...login()");
    }

    @PostMapping("/login")
    public void loginPost() {
        log.info("...login()");
    }

    @GetMapping("/success")
    public void success() {
        log.info("...success()");
    }

    @GetMapping("/fail")
    public void fail() {
        log.info("...fail()");
    }
}
