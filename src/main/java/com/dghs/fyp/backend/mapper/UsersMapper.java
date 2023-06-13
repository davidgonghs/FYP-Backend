package com.dghs.fyp.backend.mapper;

import com.dghs.fyp.backend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author David Gong
 * @since 2023-06-13
 */
public interface UsersMapper extends BaseMapper<User> {

    List<User> selectAll();

}
