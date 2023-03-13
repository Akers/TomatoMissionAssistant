package com.github.akers.tma.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 番茄计时对象 tma_tomato
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tma_tomato")
public class TmaTomato extends BaseEntity {

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
     * 番茄组ID
     */
    private String groupId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 实际消耗专注时长;专注工作时间
     */
    private Long focusTime;
    /**
     * 在番茄组中的排序
     */
    private Long sort;
    /**
     * 实际休息时长
     */
    private Long breakTime;
    /**
     * 任务ID
     */
    private String missionId;
    /**
     * 休息类型;1--短休息；2--长休息
     */
    private String breakType;
    /**
     * 番茄配置ID
     */
    private String tomatoConfigId;
    /**
     * 配置的专注工作时间
     */
    private Long focusTimeCofniged;
    /**
     * 配置的休息时长
     */
    private Long breakTimeConfiged;
    /**
     * 是否组组里的最后一轮
     */
    private String isLast;

}
