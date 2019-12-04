package com.wyh.service;

import com.wyh.entity.Blog;

import java.util.List;

/**
 * 博客Service接口
 * @author Administrator
 *
 */
public interface BlogService {

    /**
     * 根据日期分月分组查询
     * @return
     */
    public List<Blog> countList();
}
