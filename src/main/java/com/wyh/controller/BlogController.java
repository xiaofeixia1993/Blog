package com.wyh.controller;

import com.wyh.entity.Blog;
import com.wyh.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 博客Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    /**
     * 请求博客详细信息
     * @param id
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/articles/{id}")
    public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request)throws Exception{
        ModelAndView mav=new ModelAndView();
        Blog blog=blogService.findById(id);
        mav.addObject("blog",blog);
        blog.setClickHit(blog.getClickHit()+1);
        blogService.update(blog);
        mav.addObject("pageTitle", blog.getTitle()+"java开源博客系统");
        mav.addObject("mainPage", "foreground/blog/view.jsp");
        mav.setViewName("mainTemp");
        return mav;
    }
}
