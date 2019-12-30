package com.wyh.service;

import com.wyh.entity.Blogger;

/**
 * 博主Service接口
 * @author Administrator
 *
 */
public interface BloggerService {

    /**
     * 通过用户名查询用户
     * @param userName
     * @return
     */
    public Blogger getByUserName(String userName);

    /**
     * 查询博主信息
     * @return
     */
    public Blogger find();

    /**
     * 更新博主信息
     * @param blogger
     * @return
     */
    public Integer update(Blogger blogger);
}
