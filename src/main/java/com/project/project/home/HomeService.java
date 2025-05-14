package com.project.project.home;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String getHelloMessage() {
        return "Hello, World!";
    }
}