package com.july.admin.dao;

import com.july.admin.entity.RelationUserRole;
import com.july.admin.entity.RelationUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationUserRoleMapper {
    long countByExample(RelationUserRoleExample example);

    int deleteByExample(RelationUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RelationUserRole record);

    int insertSelective(RelationUserRole record);

    List<RelationUserRole> selectByExample(RelationUserRoleExample example);

    RelationUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RelationUserRole record, @Param("example") RelationUserRoleExample example);

    int updateByExample(@Param("record") RelationUserRole record, @Param("example") RelationUserRoleExample example);

    int updateByPrimaryKeySelective(RelationUserRole record);

    int updateByPrimaryKey(RelationUserRole record);
}