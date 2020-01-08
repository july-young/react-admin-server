package com.july.admin.dao;

import com.july.admin.entity.RelationRolePermission;
import com.july.admin.entity.RelationRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationRolePermissionMapper {
    long countByExample(RelationRolePermissionExample example);

    int deleteByExample(RelationRolePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RelationRolePermission record);

    int insertSelective(RelationRolePermission record);

    List<RelationRolePermission> selectByExample(RelationRolePermissionExample example);

    RelationRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RelationRolePermission record, @Param("example") RelationRolePermissionExample example);

    int updateByExample(@Param("record") RelationRolePermission record, @Param("example") RelationRolePermissionExample example);

    int updateByPrimaryKeySelective(RelationRolePermission record);

    int updateByPrimaryKey(RelationRolePermission record);
}