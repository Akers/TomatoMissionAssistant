package com.github.akers.tma.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 番茄配置对象 tma_totamo_config
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tma_totamo_config")
public class TmaTotamoConfig extends BaseEntity {

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
     * 配置id
     */
    private String configId;
    /**
     * 专注时间定时
     */
    private Long timerFocus;
    /**
     * 短休息时间定时
     */
    private Long timerShortBreak;
    /**
     * 长休息时间定时
     */
    private Long timerLongBreak;
    /**
     * 每组包含番茄数
     */
    private Long timerRounds;
    /**
     * 用户id
     */
    private String userId;

}
