package com.yhc.example.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhc.example.system.domain.entity.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leigq
 * @since 2019-06-28
 */
public interface IRoleService extends IService<Role> {
    List<Role> getUserRoles(int userId);
}
