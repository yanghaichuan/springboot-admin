package com.yhc.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhc.example.domain.entity.Permission;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leigq
 * @since 2019-06-28
 */
public interface IPermissionService extends IService<Permission> {

    List<Permission> getRolePermissions(Integer roleId);
}
