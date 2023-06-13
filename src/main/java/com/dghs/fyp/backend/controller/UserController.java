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
@Api(tags = "user API")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;




    @ApiOperation("list")
    @GetMapping("/list")
    public Object getAllUsers() {
        List<User> users = userService.list();
        return users;
    }

    @ApiOperation("pagination")
    @PostMapping("/page")
    public IPage<User> pageUser(IPage<User> page) {
        IPage<User> userIPage = userService.page(page);
        return userIPage;
    }


    @ApiOperation("getUserById")
    @GetMapping("/get")
    public User getUserById(Integer id) {
        User user = userService.getById(id);
        return user;
    }


    @ApiOperation("addUser")
    @PostMapping()
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
    @ApiOperation("updateUser")
    @PutMapping()
    public String updateUser(@RequestBody User user) {
        boolean result = userService.updateById(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    @ApiOperation("deleteUser")
    @DeleteMapping()
    public String deleteUser(@RequestBody List<String> ids) {
        boolean result = userService.removeByIds(ids);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

}
