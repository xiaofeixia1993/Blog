package com.wyh.dao;

import com.wyh.entity.BlogType;

import java.util.List;

/**
 * 博客类型Dao接口
 * @author Administrator
 *
 */
public interface BlogTypeDao {

    /**
     * 查询所有博客类型，以及对应的博客数量
     * @return
     */
    public List<BlogType> countList();

    /**
     * 通过id查找博客类型实体
     * @param id
     * @return
     */
    public BlogType findById(Integer id);
}