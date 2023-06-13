package com.dghs.fyp.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
@TableName("users")
@ApiModel(value = "Users对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("user id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("user photo")
    @TableField("user_img")
    private String userImg;

    @ApiModelProperty("user name")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("user sign ")
    @TableField("sign")
    private String sign;

    @ApiModelProperty("email")
    @TableField("email")
    private String email;

    @ApiModelProperty("phone number")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("gender maybe male or female or other")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("birthday")
    @TableField("birthday")
    private LocalDate birthday;

    @ApiModelProperty("password will decode it")
    @TableField("password")
    private String password;

    @TableField("created_time")
    private LocalDateTime createdTime;

    @TableField("updated_time")
    private LocalDateTime updatedTime;

    @TableField("updated_by")
    private Integer updatedBy;


}
