package com.wyh.service;

import com.wyh.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * 评论Service接口
 * @author Administrator
 *
 */
public interface CommentService {

    /**
     * 查询用户评论信息
     * @param map
     * @return
     */
    public List<Comment> list(Map<String,Object> map);
}
