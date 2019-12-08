package com.wyh.service.impl;

import com.wyh.dao.BlogTypeDao;
import com.wyh.entity.BlogType;
import com.wyh.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


}