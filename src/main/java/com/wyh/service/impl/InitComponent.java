package com.wyh.service.impl;

import com.wyh.entity.Blog;
import com.wyh.entity.BlogType;
import com.wyh.entity.Blogger;
import com.wyh.entity.Link;
import com.wyh.service.BlogService;
import com.wyh.service.BlogTypeService;
import com.wyh.service.BloggerService;
import com.wyh.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

@Component
public class InitComponent implements ServletContextListener, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application=sce.getServletContext();
        BloggerService bloggerService=(BloggerService) applicationContext.getBean("bloggerService");
        Blogger blogger=bloggerService.find(); // 获取博主信息
        blogger.setPassword(null);
        application.setAttribute("blogger", blogger);

        LinkService linkService=(LinkService) applicationContext.getBean("linkService");
        List<Link> linkList=linkService.list(null); // 查询所有的友情链接信息
        application.setAttribute("linkList", linkList);

        BlogTypeService blogTypeService=(BlogTypeService) applicationContext.getBean("blogTypeService");
        List<BlogType> blogTypeCountList=blogTypeService.countList(); // 查询博客类别以及博客的数量
        application.setAttribute("blogTypeCountList", blogTypeCountList);

        BlogService blogService=(BlogService) applicationContext.getBean("blogService");
        List<Blog> blogCountList=blogService.countList(); // 根据日期分组查询博客
        application.setAttribute("blogCountList", blogCountList);
    }

    public void contextDestroyed(ServletContextEvent sce) {


    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

}