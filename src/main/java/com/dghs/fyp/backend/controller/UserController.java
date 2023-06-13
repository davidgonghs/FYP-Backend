package com.dghs.fyp.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dghs.fyp.backend.entity.User;
import com.dghs.fyp.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//
//    @ApiOperation("add user")
//    @PostMapping("/add")
//    public String addUser(@RequestBody User user) {
//        user.setUserId(IdUtil);
//        boolean result = usersService.save(user);
//        return result;
//    }
//
//
//    @ApiOperation("update user")
//    @ApiOperation("delete user")

}
