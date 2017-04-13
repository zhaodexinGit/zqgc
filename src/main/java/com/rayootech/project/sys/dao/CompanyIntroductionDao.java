package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.CompanyIntroduction;

public interface CompanyIntroductionDao {
    int deleteById(String id);

    int insert(CompanyIntroduction record);

	CompanyIntroduction findById(String id);
}