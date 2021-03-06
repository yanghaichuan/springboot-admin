package com.yhc.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.domain.entity.Role;
import com.yhc.example.domain.mapper.RoleMapper;
import com.yhc.example.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getUserRoles(int userId) {
        return roleMapper.getUserRoles(userId);
    }
}
