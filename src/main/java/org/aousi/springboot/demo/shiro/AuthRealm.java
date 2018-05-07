package org.aousi.springboot.demo.shiro;

import com.sun.xml.internal.ws.api.server.Module;
import org.aousi.springboot.demo.Entities.module;
import org.aousi.springboot.demo.Entities.role;
import org.aousi.springboot.demo.Entities.user;
import org.aousi.springboot.demo.Service.userService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private userService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        user user=(user) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
        Set<role> roles = user.getRoles();
        if(roles.size()>0) {
            for(role role : roles) {
                Set<module> modules = role.getModules();
                if(modules.size()>0) {
                    for(module module : modules) {
                        permissions.add(module.getModulename());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        user user = userService.queryUserByName(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码

    }
}
