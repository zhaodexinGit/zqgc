package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.BookkeepingAgencyFAQ;

public interface BookkeepingAgencyFAQMapper {
    int deleteByPrimaryKey(String id);

    int insert(BookkeepingAgencyFAQ record);

    int insertSelective(BookkeepingAgencyFAQ record);

    BookkeepingAgencyFAQ selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BookkeepingAgencyFAQ record);

    int updateByPrimaryKeyWithBLOBs(BookkeepingAgencyFAQ record);

    int updateByPrimaryKey(BookkeepingAgencyFAQ record);
}