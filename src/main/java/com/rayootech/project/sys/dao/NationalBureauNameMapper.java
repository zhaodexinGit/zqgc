package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.NationalBureauName;

public interface NationalBureauNameMapper {
    int deleteByPrimaryKey(String id);

    int insert(NationalBureauName record);

    int insertSelective(NationalBureauName record);

    NationalBureauName selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NationalBureauName record);

    int updateByPrimaryKeyWithBLOBs(NationalBureauName record);

    int updateByPrimaryKey(NationalBureauName record);
}