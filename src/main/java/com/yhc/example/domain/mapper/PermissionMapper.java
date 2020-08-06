package com.yhc.example.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhc.example.domain.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @since 2019-06-28
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> getRolePermissions(@Param("roleId") Integer roleId);
}
