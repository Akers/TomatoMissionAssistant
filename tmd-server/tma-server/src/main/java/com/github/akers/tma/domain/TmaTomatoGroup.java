package com.github.akers.tma.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 番茄组对象 tma_tomato_group
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tma_tomato_group")
public class TmaTomatoGroup extends BaseEntity {

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
     * 长休息时间
     */
    private Long breakTime;
    /**
     * 番茄数量
     */
    private Long tomatoes;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 任务ID
     */
    private String missionId;

}
