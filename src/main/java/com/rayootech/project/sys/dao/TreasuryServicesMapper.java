package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.TreasuryServices;

public interface TreasuryServicesMapper {
    int deleteByPrimaryKey(String id);

    int insert(TreasuryServices record);

    int insertSelective(TreasuryServices record);

    TreasuryServices selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TreasuryServices record);

    int updateByPrimaryKeyWithBLOBs(TreasuryServices record);

    int updateByPrimaryKey(TreasuryServices record);
}