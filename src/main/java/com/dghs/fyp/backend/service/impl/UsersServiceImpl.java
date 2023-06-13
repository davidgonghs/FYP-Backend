package com.dghs.fyp.backend.service.impl;

import com.dghs.fyp.backend.entity.Users;
import com.dghs.fyp.backend.mapper.UsersMapper;
import com.dghs.fyp.backend.service.UsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
