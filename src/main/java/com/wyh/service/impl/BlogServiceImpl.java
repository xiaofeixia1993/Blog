package com.wyh.service.impl;

import com.wyh.dao.BlogDao;
import com.wyh.entity.Blog;
import com.wyh.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 博客Service实现类
 * @author Administrator
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    @Override
    public List<Blog> countList() {
        return blogDao.countList();
    }

    @Override
    public List<Blog> list(Map<String, Object> map) {
        return blogDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return blogDao.getTotal(map);
    }

    @Override
    public Blog findById(Integer id) {
        return blogDao.findById(id);
    }

    @Override
    public Integer update(Blog blog) {
        return blogDao.update(blog);
    }
}
