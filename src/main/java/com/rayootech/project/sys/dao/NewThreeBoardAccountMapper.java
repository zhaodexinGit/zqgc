package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.NewThreeBoardAccount;

public interface NewThreeBoardAccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(NewThreeBoardAccount record);

    int insertSelective(NewThreeBoardAccount record);

    NewThreeBoardAccount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NewThreeBoardAccount record);

    int updateByPrimaryKeyWithBLOBs(NewThreeBoardAccount record);

    int updateByPrimaryKey(NewThreeBoardAccount record);
}