package com.dghs.fyp.backend.controller;

import com.dghs.fyp.backend.entity.User;
import com.dghs.fyp.backend.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
public class UsersController {

    private final UsersService usersService;

    @ApiOperation("get all users")
    @RequestMapping("/all")
    public Object getAllUsers() {
        List<User> users = usersService.selectAll();
        return users;
    }

}
