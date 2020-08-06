package com.yhc.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhc.example.domain.entity.UserRole;
import com.yhc.example.domain.mapper.UserRoleMapper;
import com.yhc.example.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leigq
 * @since 2019-06-28
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
