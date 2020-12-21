package com.yhc.example.system.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhc.example.system.domain.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @since 2019-06-28
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getUserRoles(@Param("userId") int userId);
}
