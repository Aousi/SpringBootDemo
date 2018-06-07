package org.aousi.springboot.demo;

import org.aousi.springboot.demo.shiro.AuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	@Configuration
	@MapperScan("org.aousi.springboot.demo.mapper")
	public class MyBatisConfig {
	}

	@Configuration
	public class ShiroConfig {


        @Bean
		public ShiroFilterFactoryBean shiroFilter(SecurityManager SecurityManager){
            ShiroFilterFactoryBean sffb = new ShiroFilterFactoryBean();
			sffb.setSecurityManager(SecurityManager);

			//拦截器.
			Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
			// 配置不会被拦截的链接 顺序判断
            filterChainDefinitionMap.put("/static/**", "anon");
			//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
			filterChainDefinitionMap.put("/user/logout.do", "logout");
			//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
			//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
			filterChainDefinitionMap.put("/templates/**", "authc");
			// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
			sffb.setLoginUrl("/login");
			// 登录成功后要跳转的链接
			sffb.setSuccessUrl("/");
			//未授权界面;
			sffb.setUnauthorizedUrl("/403");
			sffb.setFilterChainDefinitionMap(filterChainDefinitionMap);
			return sffb;
		}

        @Bean
        public AuthRealm myShiroRealm(){
            AuthRealm myShiroRealm = new AuthRealm();
            return myShiroRealm;
        }


        @Bean
        public SecurityManager securityManager(){
            DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
            securityManager.setRealm(myShiroRealm());
            return securityManager;
        }

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
