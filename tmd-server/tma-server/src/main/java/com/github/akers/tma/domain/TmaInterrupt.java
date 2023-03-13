package com.github.akers.tma.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 中断对象 tma_interrupt
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tma_interrupt")
public class TmaInterrupt extends BaseEntity {

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
     * 中断关联的番茄id
     */
    private String tomatoId;
    /**
     * 中断开始时间
     */
    private Date startTime;
    /**
     * 中断结束时间
     */
    private Date endTime;
    /**
     * 中断时长
     */
    private Long interruptedTime;
    /**
     * 中断类型;1--专注工作中断；2--短休息中断；3--长休息中断
     */
    private String interruptType;

}
