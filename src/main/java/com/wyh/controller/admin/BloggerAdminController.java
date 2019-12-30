package com.wyh.controller.admin;

import com.wyh.entity.Blogger;
import com.wyh.service.BloggerService;
import com.wyh.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员博主Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

    @Resource
    private BloggerService bloggerService;

    /**
     * 查询博主信息
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/find")
    public String find(HttpServletResponse response)throws Exception{
        Blogger blogger=bloggerService.find();
        JSONObject jsonObject=JSONObject.fromObject(blogger);
        ResponseUtil.write(response, jsonObject);
        return null;
    }
}
