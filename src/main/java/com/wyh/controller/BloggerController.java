package com.wyh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyh.entity.Blogger;
import com.wyh.service.BloggerService;
import com.wyh.util.CryptographyUtil;

/**
 * 博主Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping("/login")
    public String login(Blogger blogger,HttpServletRequest request){
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "wyh"));
        try{
            subject.login(token); // 登录验证		
            return "redirect:/admin/main.jsp";
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("blogger", blogger);
            request.setAttribute("errorInfo", "用户名或者密码错误！");
            return "login";
        }
    }
}