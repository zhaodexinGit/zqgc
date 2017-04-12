package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.CompanyIntroduction;

public interface CompanyIntroductionMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanyIntroduction record);

    int insertSelective(CompanyIntroduction record);

    CompanyIntroduction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CompanyIntroduction record);

    int updateByPrimaryKeyWithBLOBs(CompanyIntroduction record);

    int updateByPrimaryKey(CompanyIntroduction record);
}