package com.wyh.service;

import com.wyh.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * 友情链接Service接口
 * @author Administrator
 *
 */
public interface LinkService {

    /**
     * 查找友情链接信息
     * @param map
     * @return
     */
    public List<Link> list(Map<String,Object> map);
}
