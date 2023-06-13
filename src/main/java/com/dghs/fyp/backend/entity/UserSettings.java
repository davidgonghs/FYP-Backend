package com.dghs.fyp.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
@TableName("user_settings")
@ApiModel(value = "UserSettings对象", description = "")
public class UserSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private Integer userId;

    @TableField("calculation_mode")
    private String calculationMode;

    @TableField("pomodoro_intervals")
    private Integer pomodoroIntervals;

    @TableField("pomodoro_rest_time")
    private Integer pomodoroRestTime;

    @ApiModelProperty("url of the voice reminder where are the user")
    @TableField("voice_reminder_1")
    private String voiceReminder1;

    @ApiModelProperty("incorrect_posture")
    @TableField("voice_reminder_2")
    private String voiceReminder2;

    @ApiModelProperty("rest_time")
    @TableField("voice_reminder_3")
    private String voiceReminder3;

    @TableField("daily_usage_reminder_time")
    private LocalTime dailyUsageReminderTime;

    @TableField("created_time")
    private LocalDateTime createdTime;

    @TableField("updated_time")
    private LocalDateTime updatedTime;

    @TableField("updated_by")
    private Integer updatedBy;


}
