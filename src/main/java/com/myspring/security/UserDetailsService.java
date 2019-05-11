package com.myspring.security;

import com.myspring.beans.UserBean;
import com.myspring.entities.Role;
import com.myspring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Assylkhan
 * on 11.05.2019
 * @project springFoodOrder
 */
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    private UserBean userBean;

    @Autowired
    public UserDetailsService(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User myUser = userBean.getUser(s);
        Set<Role> roles = new HashSet<Role>();
        roles.add(myUser.getRole());
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        for(Role r : roles){
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(myUser.getLogin(), myUser.getPassword(), authorities);
        return securityUser;
    }
}
