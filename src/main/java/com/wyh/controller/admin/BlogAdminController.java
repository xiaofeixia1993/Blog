package com.wyh.controller.admin;

import com.wyh.entity.Blog;
import com.wyh.service.BlogService;
import com.wyh.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员博客Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

    @Resource
    private BlogService blogService;

    /**
     * 添加或者修改博客信息
     * @param blog
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(Blog blog, HttpServletResponse response)throws Exception{
        int resultTotal=0;
        if(blog.getId()==null){
            resultTotal=blogService.add(blog);
        }else{

        }
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
}
