package com.github.akers.tma.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 团队对象 tma_team
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tma_team")
public class TmaTeam extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 乐观锁
     */
    @Version
    private String version;
    /**
     * 团队名称
     */
    private String teamName;
    /**
     * 机构id
     */
    private String deptId;
    /**
     * 团队介绍
     */
    private String teamDesc;

}
