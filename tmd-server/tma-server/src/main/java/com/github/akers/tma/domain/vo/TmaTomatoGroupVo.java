package com.github.akers.tma.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 番茄组视图对象 tma_tomato_group
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@ExcelIgnoreUnannotated
public class TmaTomatoGroupVo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 长休息时间
     */
    @ExcelProperty(value = "长休息时间")
    private Long breakTime;

    /**
     * 番茄数量
     */
    @ExcelProperty(value = "番茄数量")
    private Long tomatoes;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    private String userId;

    /**
     * 任务ID
     */
    @ExcelProperty(value = "任务ID")
    private String missionId;


}
