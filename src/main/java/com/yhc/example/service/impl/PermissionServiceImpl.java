package com.yhc.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.domain.entity.Permission;
import com.yhc.example.domain.mapper.PermissionMapper;
import com.yhc.example.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leigq
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
