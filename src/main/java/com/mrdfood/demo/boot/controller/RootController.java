package com.mrdfood.demo.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class RootController {

    @Value("${info.app.version:0.0.0}")
    private String version;

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("version", version);
        return "index";
    }
}