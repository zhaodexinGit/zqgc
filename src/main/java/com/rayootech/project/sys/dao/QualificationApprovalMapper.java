package com.rayootech.project.sys.dao;

import com.rayootech.project.sys.entity.QualificationApproval;

public interface QualificationApprovalMapper {
    int deleteByPrimaryKey(String id);

    int insert(QualificationApproval record);

    int insertSelective(QualificationApproval record);

    QualificationApproval selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QualificationApproval record);

    int updateByPrimaryKeyWithBLOBs(QualificationApproval record);

    int updateByPrimaryKey(QualificationApproval record);
}