package com.github.akers.tma.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 番茄计时业务对象 tma_tomato
 *
 * @author ruoyi
 * @date 2023-03-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TmaTomatoBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 番茄组ID
     */
    @NotBlank(message = "番茄组ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String groupId;

    /**
     * 用户ID
     */
    @NotBlank(message = "用户ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userId;

    /**
     * 实际消耗专注时长;专注工作时间
     */
    @NotNull(message = "实际消耗专注时长;专注工作时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long focusTime;

    /**
     * 在番茄组中的排序
     */
    @NotNull(message = "在番茄组中的排序不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long sort;

    /**
     * 实际休息时长
     */
    @NotNull(message = "实际休息时长不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long breakTime;

    /**
     * 任务ID
     */
    @NotBlank(message = "任务ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String missionId;

    /**
     * 休息类型;1--短休息；2--长休息
     */
    @NotBlank(message = "休息类型;1--短休息；2--长休息不能为空", groups = { AddGroup.class, EditGroup.class })
    private String breakType;

    /**
     * 番茄配置ID
     */
    @NotBlank(message = "番茄配置ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String tomatoConfigId;

    /**
     * 配置的专注工作时间
     */
    @NotNull(message = "配置的专注工作时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long focusTimeCofniged;

    /**
     * 配置的休息时长
     */
    @NotNull(message = "配置的休息时长不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long breakTimeConfiged;

    /**
     * 是否组组里的最后一轮
     */
    @NotBlank(message = "是否组组里的最后一轮不能为空", groups = { AddGroup.class, EditGroup.class })
    private String isLast;


}
