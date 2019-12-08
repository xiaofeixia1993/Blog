package com.wyh.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyh.dao.BloggerDao;
import com.wyh.entity.Blogger;
import com.wyh.service.BloggerService;

/**
 * 博主Service实现类
 * @author Administrator
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService{

    @Autowired
    private BloggerDao bloggerDao;

    @Override
    public Blogger getByUserName(String userName) {
        return bloggerDao.getByUserName(userName);
    }

    @Override
    public Blogger find() {
        return bloggerDao.find();
    }
}
