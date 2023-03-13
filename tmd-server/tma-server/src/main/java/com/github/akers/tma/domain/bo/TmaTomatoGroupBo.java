package com.github.akers.tma.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 番茄组业务对象 tma_tomato_group
 *
 * @author ruoyi
 * @date 2023-03-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TmaTomatoGroupBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 长休息时间
     */
    @NotNull(message = "长休息时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long breakTime;

    /**
     * 番茄数量
     */
    @NotNull(message = "番茄数量不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long tomatoes;

    /**
     * 用户ID
     */
    @NotBlank(message = "用户ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userId;

    /**
     * 任务ID
     */
    @NotBlank(message = "任务ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String missionId;


}
