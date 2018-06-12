package org.aousi.springboot.demo.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

@Component
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new SimpleHash("MD5",new String(utoken.getPassword()),utoken.getUsername(),2).toHex();
        //获得数据库中的密码
        String dbPassword=(String) info.getCredentials();

        return this.equals(inPassword, dbPassword);
    }
}
