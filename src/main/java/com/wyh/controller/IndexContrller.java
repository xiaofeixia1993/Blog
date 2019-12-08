package com.wyh.controller;

import com.wyh.entity.Blog;
import com.wyh.entity.PageBean;
import com.wyh.service.BlogService;
import com.wyh.util.PageUtil;
import com.wyh.util.StringUtil;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页Contrller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class IndexContrller {

    @Resource
    private BlogService blogService;

    /**
     * 请求主页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value="page",required=false)String page, HttpServletRequest request)throws Exception{
        ModelAndView mav=new ModelAndView();
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page),10);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Blog> blogList=blogService.list(map);
        for(Blog blog:blogList){
            List<String> imageList=blog.getImageList();
            String blogInfo=blog.getContent();//获取博客内容
            Document doc= Jsoup.parse(blogInfo);//Jsoup把博客内容解析为doc文档
            Elements jpgs = doc.select("img[src$=.jpg]");//获取doc文档中后缀为.jpg的图片
            for(int i=0;i<jpgs.size();i++){
                Element jpg=jpgs.get(i);
                imageList.add(jpg.toString());
                if(i==2){
                    break;
                }
            }
        }
        mav.addObject("blogList", blogList);
        StringBuffer param=new StringBuffer();
        mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(map), Integer.parseInt(page), 10, param.toString()));
        mav.addObject("pageTitle", "java开源博客系统");
        mav.addObject("mainPage", "foreground/blog/list.jsp");
        mav.setViewName("mainTemp");
        return mav;
    }


    public void test(HttpServletRequest request) {
        System.out.println(request.getContextPath());
    }
}
