package com.yhc.example.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.system.domain.entity.Permission;
import com.yhc.example.system.domain.mapper.PermissionMapper;
import com.yhc.example.system.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author test
 * @since 2019-06-28
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getRolePermissions(Integer roleId) {
        return permissionMapper.getRolePermissions(roleId);
    }
}
