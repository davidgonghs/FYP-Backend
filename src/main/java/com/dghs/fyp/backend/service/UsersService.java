package com.dghs.fyp.backend.service;

import com.dghs.fyp.backend.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author David Gong
 * @since 2023-06-13
 */
public interface UsersService extends IService<User> {

    List<User> selectAll();
}
