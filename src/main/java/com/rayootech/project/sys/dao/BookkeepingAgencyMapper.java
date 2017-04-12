package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.BookkeepingAgency;

public interface BookkeepingAgencyMapper {
    int deleteByPrimaryKey(String id);

    int insert(BookkeepingAgency record);

    int insertSelective(BookkeepingAgency record);

    BookkeepingAgency selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BookkeepingAgency record);

    int updateByPrimaryKeyWithBLOBs(BookkeepingAgency record);

    int updateByPrimaryKey(BookkeepingAgency record);
}