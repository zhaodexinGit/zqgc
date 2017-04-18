package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.BookkeepingAgencyFAQ;

public interface BookkeepingAgencyFAQDao {
    int deleteById(String id);

    int insert(BookkeepingAgencyFAQ record);

    BookkeepingAgencyFAQ findById(String id);
}