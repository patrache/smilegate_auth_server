package com.example.api_server.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class testController {

    @GetMapping("/test")
    fun testGet():String{
        return "this is api_server get method"
    }

    @PostMapping("/test")
    fun testPost():String{
        return "this is api_server post method"
    }
}