package org.aousi.springboot.demo;

import org.aousi.springboot.demo.shiro.AuthRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	@Configuration
	@MapperScan("org.aousi.springboot.demo.mapper")
	public class MyBatisConfig {
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
