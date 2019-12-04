package com.wyh.service;

import com.wyh.entity.BlogType;

import java.util.List;

/**
 * 博客类型Service接口
 * @author Administrator
 *
 */
public interface BlogTypeService {

    /**
     * 查询所有博客类型，以及对应的博客数量
     * @return
     */
    public List<BlogType> countList();
}
