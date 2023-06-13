package com.dghs.fyp.backend.service.impl;

import com.dghs.fyp.backend.service.RoleService;
import com.dghs.fyp.backend.sys.entity.Role;
import com.dghs.fyp.backend.mapper.RoleMapper;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
