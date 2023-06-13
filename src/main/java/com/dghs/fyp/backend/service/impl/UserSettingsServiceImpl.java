package com.dghs.fyp.backend.service.impl;

import com.dghs.fyp.backend.sys.entity.UserSettings;
import com.dghs.fyp.backend.mapper.UserSettingsMapper;
import com.dghs.fyp.backend.service.UserSettingsService;
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
public class UserSettingsServiceImpl extends ServiceImpl<UserSettingsMapper, UserSettings> implements UserSettingsService {

}
