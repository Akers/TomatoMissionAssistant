package com.github.akers.tma.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务指派对象 tma_mission_assigned
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tma_mission_assigned")
public class TmaMissionAssigned extends BaseEntity {

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
     * 用户ID
     */
    private String userId;
    /**
     * 任务ID;tmd_mission表的mission_id
     */
    private String missionId;
    /**
     * 指派时间;指派任务时间
     */
    private String assignTime;

}
