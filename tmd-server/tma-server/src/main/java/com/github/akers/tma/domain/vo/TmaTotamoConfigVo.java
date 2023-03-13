package com.github.akers.tma.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 番茄配置视图对象 tma_totamo_config
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@ExcelIgnoreUnannotated
public class TmaTotamoConfigVo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 配置id
     */
    @ExcelProperty(value = "配置id")
    private String configId;

    /**
     * 专注时间定时
     */
    @ExcelProperty(value = "专注时间定时")
    private Long timerFocus;

    /**
     * 短休息时间定时
     */
    @ExcelProperty(value = "短休息时间定时")
    private Long timerShortBreak;

    /**
     * 长休息时间定时
     */
    @ExcelProperty(value = "长休息时间定时")
    private Long timerLongBreak;

    /**
     * 每组包含番茄数
     */
    @ExcelProperty(value = "每组包含番茄数")
    private Long timerRounds;

    /**
     * 用户id
     */
    @ExcelProperty(value = "用户id")
    private String userId;


}
