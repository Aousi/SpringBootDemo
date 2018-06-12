package org.aousi.springboot.demo.shiro;

import org.aousi.springboot.demo.Entities.Module;
import org.aousi.springboot.demo.Entities.User;
import org.aousi.springboot.demo.Entities.Role;
import org.aousi.springboot.demo.Service.userService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private userService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User User =(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
        Set<Role> Roles = User.getRoles();
        if(Roles.size()>0) {
            for(Role Role : Roles) {
                Set<Module> Modules = Role.getModules();
                if(Modules.size()>0) {
                    for(Module Module : Modules) {
                        permissions.add(Module.getModulename());
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
        User User = userService.identifyUser(username);
        if (User == null){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(User, User.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码

    }
}
