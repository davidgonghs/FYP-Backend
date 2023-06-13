package com.dghs.fyp.backend.service.impl;

import com.dghs.fyp.backend.entity.User;
import com.dghs.fyp.backend.mapper.UserMapper;
import com.dghs.fyp.backend.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author David Gong
 * @since 2023-06-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
