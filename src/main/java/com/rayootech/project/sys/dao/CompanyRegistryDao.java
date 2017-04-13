package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.CompanyRegistry;

public interface CompanyRegistryDao {
    int deleteById(String id);

    int insert(CompanyRegistry record);

    CompanyRegistry findById(String id);
}