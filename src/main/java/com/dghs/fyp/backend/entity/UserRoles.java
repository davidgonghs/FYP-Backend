package com.dghs.fyp.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author David Gong
 * @since 2023-06-13
 */
@Getter
@Setter
@TableName("user_roles")
@ApiModel(value = "UserRoles对象", description = "")
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_role_id")
    private Long userRoleId;

    @TableField("user_id")
    private Long userId;

    @TableField("role_id")
    private Long roleId;


}
