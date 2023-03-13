package com.github.akers.tma.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 团队业务对象 tma_team
 *
 * @author ruoyi
 * @date 2023-03-01
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TmaTeamBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 团队名称
     */
    @NotBlank(message = "团队名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String teamName;

    /**
     * 机构id
     */
    @NotBlank(message = "机构id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String deptId;

    /**
     * 团队介绍
     */
    @NotBlank(message = "团队介绍不能为空", groups = { AddGroup.class, EditGroup.class })
    private String teamDesc;


}
