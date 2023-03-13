package com.github.akers.tma.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 中断业务对象 tma_interrupt
 *
 * @author ruoyi
 * @date 2023-03-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TmaInterruptBo extends BaseEntity {

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
     * 中断关联的番茄id
     */
    @NotBlank(message = "中断关联的番茄id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String tomatoId;

    /**
     * 中断开始时间
     */
    @NotNull(message = "中断开始时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date startTime;

    /**
     * 中断结束时间
     */
    @NotNull(message = "中断结束时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date endTime;

    /**
     * 中断时长
     */
    @NotNull(message = "中断时长不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long interruptedTime;

    /**
     * 中断类型;1--专注工作中断；2--短休息中断；3--长休息中断
     */
    @NotBlank(message = "中断类型;1--专注工作中断；2--短休息中断；3--长休息中断不能为空", groups = { AddGroup.class, EditGroup.class })
    private String interruptType;


}
