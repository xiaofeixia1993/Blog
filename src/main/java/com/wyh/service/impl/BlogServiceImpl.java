package com.wyh.service.impl;

import com.wyh.dao.BlogDao;
import com.wyh.entity.Blog;
import com.wyh.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客Service实现类
 * @author Administrator
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    public List<Blog> countList() {
        return blogDao.countList();
    }

}
