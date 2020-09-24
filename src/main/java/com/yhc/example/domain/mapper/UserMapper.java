package com.yhc.example.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhc.example.domain.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author leigq
 * @since 2019-06-28
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> listUsers(User user);
}
