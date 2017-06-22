package com.shouyou.app.dao;

import com.shouyou.app.entity.AppShow;

public interface AppShowDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AppShow record);

    int insertSelective(AppShow record);

    AppShow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppShow record);

    int updateByPrimaryKey(AppShow record);
}