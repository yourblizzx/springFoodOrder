package com.myspring.controllers;

import com.myspring.beans.RoleBean;
import com.myspring.beans.UserBean;
import com.myspring.beans.utils.Utils;
import com.myspring.entities.Role;
import com.myspring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private Utils utils;
    private UserBean userBean;
    private RoleBean roleBean;

    @Autowired
    public MainController(UserBean userBean,
                          RoleBean roleBean,
                          Utils utils) {
        this.userBean = userBean;
        this.roleBean = roleBean;
        this.utils = utils;
    }

    @GetMapping(value = { "/"})
    public ModelAndView indexPage() {
        return new ModelAndView("auth/login");
    }

    @GetMapping(value = {"register"})
    public ModelAndView registerPage() {
        return new ModelAndView("auth/register");
    }

    @PostMapping(value = {"register"})
    public String registerUser(@RequestParam String repassword,
                               @RequestParam String password,
                               @RequestParam String login,
                               @RequestParam String name) {
        if(password.equals(repassword)){
            Role role = roleBean.getRole(RoleBean.ROLE_USER_ID);
            String securedPassword = utils.stringToMD5(password);
            User user = User.builder()
                    .login(login)
                    .password(securedPassword)
                    .role(role)
                    .name(name).build();
            userBean.addUser(user);
            return "redirect: /";
        }else{
            return "redirect: /?error=2";
        }

    }


    @RequestMapping(value = {"profile"})
    public ModelAndView profilePage() {
        return new ModelAndView("admin/index");
    }

    @RequestMapping(value = {"403"})
    public ModelAndView unauthorized() { return new ModelAndView("auth/403");
    }

}