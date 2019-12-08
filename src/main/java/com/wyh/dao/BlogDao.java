package com.wyh.dao;

import com.wyh.entity.Blog;

import java.util.List;
import java.util.Map;

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

    /**
     * 分页查询博客
     * @param map
     * @return
     */
    public List<Blog> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);

    /**
     * 根据id查找实体
     * @param id
     * @return
     */
    public Blog findById(Integer id);

    /**
     * 更新博客信息
     * @param blog
     * @return
     */
    public Integer update(Blog blog);
}
