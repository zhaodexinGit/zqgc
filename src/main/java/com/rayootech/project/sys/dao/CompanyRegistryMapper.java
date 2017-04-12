package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.CompanyRegistry;

public interface CompanyRegistryMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanyRegistry record);

    int insertSelective(CompanyRegistry record);

    CompanyRegistry selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CompanyRegistry record);

    int updateByPrimaryKeyWithBLOBs(CompanyRegistry record);

    int updateByPrimaryKey(CompanyRegistry record);
}