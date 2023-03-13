package com.github.akers.tma.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 番茄配置业务对象 tma_totamo_config
 *
 * @author ruoyi
 * @date 2023-03-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TmaTotamoConfigBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 配置id
     */
    @NotBlank(message = "配置id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String configId;

    /**
     * 专注时间定时
     */
    @NotNull(message = "专注时间定时不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long timerFocus;

    /**
     * 短休息时间定时
     */
    @NotNull(message = "短休息时间定时不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long timerShortBreak;

    /**
     * 长休息时间定时
     */
    @NotNull(message = "长休息时间定时不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long timerLongBreak;

    /**
     * 每组包含番茄数
     */
    @NotNull(message = "每组包含番茄数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long timerRounds;

    /**
     * 用户id
     */
    @NotBlank(message = "用户id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userId;


}
