package com.dghs.fyp.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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
@TableName("usage_history")
@ApiModel(value = "UsageHistory对象", description = "")
public class UsageHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("history_id")
    private String historyId;

    @TableField("user_id")
    private String userId;

    @TableField("usage_time")
    private BigDecimal usageTime;

    @TableField("sitting_accuracy")
    private BigDecimal sittingAccuracy;

    @TableField("created_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;


}
