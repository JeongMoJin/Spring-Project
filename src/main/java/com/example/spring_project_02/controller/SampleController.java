package com.example.spring_project_02.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Log4j2
@Controller
public class SampleController {
    @GetMapping("/hello")
    public void hello() {
        log.info("hello()...");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1()...");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name="name", defaultValue="aaa") String name,
                    @RequestParam(name="age", defaultValue="16") int age) {
        log.info("ex2()...");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3()...");
        log.info("dueDate: " + dueDate);
    }











}