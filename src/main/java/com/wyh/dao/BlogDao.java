package com.wyh.dao;

import com.wyh.entity.Blog;

import java.util.List;

/**
 * 博客Dao接口
 * @author Administrator
 *
 */
public interface BlogDao {

    /**
     * 根据日期分月分组查询
     * @return
     */
    public List<Blog> countList();
}
