package com.wyh.service.impl;

import com.wyh.dao.BlogTypeDao;
import com.wyh.entity.BlogType;
import com.wyh.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 博客类型Service实现类
 * @author Administrator
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeDao blogTypeDao;

    @Override
    public List<BlogType> countList() {
        return blogTypeDao.countList();
    }

    public List<BlogType> list(Map<String, Object> map) {
        return blogTypeDao.list(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return blogTypeDao.getTotal(map);
    }

    public Integer add(BlogType blogType) {
        return blogTypeDao.add(blogType);
    }

    public Integer update(BlogType blogType) {
        return blogTypeDao.update(blogType);
    }

    public Integer delete(Integer id) {
        return blogTypeDao.delete(id);
    }
}