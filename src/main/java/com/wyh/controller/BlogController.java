package com.wyh.controller;

import com.wyh.entity.Blog;
import com.wyh.service.BlogService;
import com.wyh.service.CommentService;
import com.wyh.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    @Resource
    private CommentService commentService;

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
        String keyWords=blog.getKeyWord();
        if(StringUtil.isNotEmpty(keyWords)){
            String arr[]=keyWords.split(" ");
            mav.addObject("keyWords", StringUtil.filterWhite(Arrays.asList(arr)));
        }else{
            mav.addObject("keyWords",null);
        }
        mav.addObject("blog",blog);
        blog.setClickHit(blog.getClickHit()+1);
        blogService.update(blog);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("blogId", blog.getId());
        map.put("state", 1);
        mav.addObject("commentList", commentService.list(map));
        mav.addObject("pageCode", this.getUpAndDownPageCode(blogService.getLastBlog(id), blogService.getNextBlog(id), request.getServletContext().getContextPath()));
        mav.addObject("pageTitle", blog.getTitle()+"java开源博客系统");
        mav.addObject("mainPage", "foreground/blog/view.jsp");
        mav.setViewName("mainTemp");
        return mav;
    }

    /**
     * 获取上一篇博客和下一篇博客
     * @param lastBlog
     * @param nextBlog
     * @param projectContext
     * @return
     */
    private String getUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
        StringBuffer pageCode=new StringBuffer();
        if(lastBlog==null || lastBlog.getId()==null){
            pageCode.append("<p>上一篇：没有了</p>");
        }else{
            pageCode.append("<p>上一篇：<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
        }

        if(nextBlog==null || nextBlog.getId()==null){
            pageCode.append("<p>下一篇：没有了</p>");
        }else{
            pageCode.append("<p>下一篇：<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
        }
        return pageCode.toString();
    }
}
