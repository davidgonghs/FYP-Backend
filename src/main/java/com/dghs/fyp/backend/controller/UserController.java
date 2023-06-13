package com.dghs.fyp.backend.controller;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dghs.fyp.backend.common.config.ServerConfig;
import com.dghs.fyp.backend.entity.User;
import com.dghs.fyp.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author David Gong
 * @since 2023-06-13
 */
@Api(tags = "user management")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @ApiOperation("get all users")
    @RequestMapping("/all")
    public Object getAllUsers() {
        List<User> users = userService.list();
        return users;
    }

    @ApiOperation("get user by page")
    @PostMapping("/page")
    public IPage<User> pageUser(IPage<User> page) {
        IPage<User> userIPage = userService.page(page);
        return userIPage;
    }


    @ApiOperation("get user by id")
    @RequestMapping("/get")
    public User getUserById(Integer id) {
        User user = userService.getById(id);
        return user;
    }


    @ApiOperation("add user")
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        user.setUserId(IdUtil.getSnowflake(ServerConfig.WORKER_ID, ServerConfig.DATA_CENTER_ID).nextIdStr());
        boolean result = userService.save(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }
//
//
    @ApiOperation("update user")
    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        boolean result = userService.updateById(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    @ApiOperation("delete user")
    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody List<String> ids) {
        boolean result = userService.removeByIds(ids);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

}
