package com.github.akers.tma.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务历史业务对象 tma_mission_his
 *
 * @author ruoyi
 * @date 2023-03-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TmaMissionHisBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 团队id
     */
    @NotBlank(message = "团队id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String teamId;

    /**
     * 任务预估工期（小时）
     */
    @NotNull(message = "任务预估工期（小时）不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long missionDuration;

    /**
     * 任务名称
     */
    @NotBlank(message = "任务名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String missionName;

    /**
     * 任务类型
     */
    @NotBlank(message = "任务类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String missionType;

    /**
     * 任务状态
     */
    @NotBlank(message = "任务状态不能为空", groups = { AddGroup.class, EditGroup.class })
    private String missionStatus;

    /**
     * 任务描述
     */
    @NotBlank(message = "任务描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String missionDesc;

    /**
     * 父级任务id
     */
    @NotBlank(message = "父级任务id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String parentId;

    /**
     * 任务ID;创建任务时生成，修改任务时不变
     */
    @NotBlank(message = "任务ID;创建任务时生成，修改任务时不变不能为空", groups = { AddGroup.class, EditGroup.class })
    private String missionId;


}
