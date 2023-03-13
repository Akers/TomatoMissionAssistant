package com.github.akers.tma.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务指派业务对象 tma_mission_assigned
 *
 * @author ruoyi
 * @date 2023-03-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TmaMissionAssignedBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 用户ID
     */
    @NotBlank(message = "用户ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userId;

    /**
     * 任务ID;tmd_mission表的mission_id
     */
    @NotBlank(message = "任务ID;tmd_mission表的mission_id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String missionId;

    /**
     * 指派时间;指派任务时间
     */
    @NotBlank(message = "指派时间;指派任务时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private String assignTime;


}
