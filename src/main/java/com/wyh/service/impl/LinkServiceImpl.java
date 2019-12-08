package com.wyh.service.impl;

import com.wyh.dao.LinkDao;
import com.wyh.entity.Link;
import com.wyh.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 友情链接Service实现类
 * @author Administrator
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkDao linkDao;

    @Override
    public List<Link> list(Map<String, Object> map) {
        return linkDao.list(map);
    }





}
