package com.wyh.service.impl;

import com.wyh.dao.CommentDao;
import com.wyh.entity.Comment;
import com.wyh.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 评论Service实现类
 * @author Administrator
 *
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public List<Comment> list(Map<String, Object> map) {
        return commentDao.list(map);
    }

    @Override
    public int add(Comment comment) {
        return commentDao.add(comment);
    }
}
