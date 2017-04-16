package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.BaseDictionary;


public interface BaseDictionaryDao{
    

    int deleteById(String BDID);

    int insertRecord(BaseDictionary record);

    int insertSelective(BaseDictionary record);

    BaseDictionary findById(String BDID);

    int updateByPrimaryKeySelective(BaseDictionary record);

    int updateById(BaseDictionary record);
}