package com.wyh.controller.admin;

import com.wyh.service.BloggerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
}
