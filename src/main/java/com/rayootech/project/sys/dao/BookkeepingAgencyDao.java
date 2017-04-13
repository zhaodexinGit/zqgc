package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.BookkeepingAgency;

public interface BookkeepingAgencyDao {
    int deleteById(String id);

    int insert(BookkeepingAgency record);

    BookkeepingAgency findById(String id);
}