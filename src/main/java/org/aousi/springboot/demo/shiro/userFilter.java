package org.aousi.springboot.demo.shiro;

import org.aousi.springboot.demo.Constants;
import org.aousi.springboot.demo.Service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


@Component
public class userFilter extends PathMatchingFilter {
    @Autowired
    private userService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, userService.queryUserByName(username));
        return true;
    }
}
