package com.wyh.dao;

import com.wyh.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * 评论Dao接口
 * @author Administrator
 *
 */
public interface CommentDao {

    /**
     * 查询用户评论信息
     * @param map
     * @return
     */
    public List<Comment> list(Map<String,Object> map);
}
