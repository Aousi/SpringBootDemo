package org.aousi.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class demoController {

    @RequestMapping("/")
    public String login(){
        return "login";
    }
}
