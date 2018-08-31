package com.service;

import com.jpa.UserJPA;
import com.pojo.JefUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 因为我们自定义了JefUser并且继承了UserDetails
 * 意味着Spring Security将会使用自定义的JefUser
 *
 */
public class CustomUserServiceImpl implements UserDetailsService {

    @Autowired
    UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        JefUser user = userJPA.findByOnlyAccount(account);
        if( user == null ){
            throw new UsernameNotFoundException("用不存在");
        }
        return user;
    }
}
