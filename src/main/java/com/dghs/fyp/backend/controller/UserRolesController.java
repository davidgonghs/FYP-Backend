package com.dghs.fyp.backend.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author David Gong
 * @since 2023-06-13
 */
@Api(tags = "user-roles API")
@RestController
@RequestMapping("/user-roles")
@RequiredArgsConstructor
public class UserRolesController {

}
