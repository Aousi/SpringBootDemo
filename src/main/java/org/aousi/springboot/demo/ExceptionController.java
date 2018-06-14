package org.aousi.springboot.demo;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = UnauthorizedException.class)
    public ModelAndView UnauthorizedException(){
        Map<String,Object> back = new HashMap<>();
        back.put("toUrl","/");
        back.put("msg","当前用户的角色无法使用该功能！即将跳转回首页……");
        return new ModelAndView("transition",back);
    }
}
