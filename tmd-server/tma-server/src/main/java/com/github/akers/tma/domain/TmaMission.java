package com.github.akers.tma.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务对象 tma_mission
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tma_mission")
public class TmaMission extends BaseEntity {

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
     * 团队id
     */
    private String teamId;
    /**
     * 任务预估工期（小时）
     */
    private Long missionDuration;
    /**
     * 任务名称
     */
    private String missionName;
    /**
     * 任务类型
     */
    private String missionType;
    /**
     * 任务状态
     */
    private String missionStatus;
    /**
     * 任务描述
     */
    private String missionDesc;
    /**
     * 父级任务id
     */
    private String parentId;
    /**
     * 任务ID;创建任务时生成，修改任务时不变
     */
    private String missionId;

}
