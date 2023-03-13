package com.github.akers.tma.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 番茄计时视图对象 tma_tomato
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@ExcelIgnoreUnannotated
public class TmaTomatoVo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 番茄组ID
     */
    @ExcelProperty(value = "番茄组ID")
    private String groupId;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    private String userId;

    /**
     * 实际消耗专注时长;专注工作时间
     */
    @ExcelProperty(value = "实际消耗专注时长;专注工作时间")
    private Long focusTime;

    /**
     * 在番茄组中的排序
     */
    @ExcelProperty(value = "在番茄组中的排序")
    private Long sort;

    /**
     * 实际休息时长
     */
    @ExcelProperty(value = "实际休息时长")
    private Long breakTime;

    /**
     * 任务ID
     */
    @ExcelProperty(value = "任务ID")
    private String missionId;

    /**
     * 休息类型;1--短休息；2--长休息
     */
    @ExcelProperty(value = "休息类型;1--短休息；2--长休息")
    private String breakType;

    /**
     * 番茄配置ID
     */
    @ExcelProperty(value = "番茄配置ID")
    private String tomatoConfigId;

    /**
     * 配置的专注工作时间
     */
    @ExcelProperty(value = "配置的专注工作时间")
    private Long focusTimeCofniged;

    /**
     * 配置的休息时长
     */
    @ExcelProperty(value = "配置的休息时长")
    private Long breakTimeConfiged;

    /**
     * 是否组组里的最后一轮
     */
    @ExcelProperty(value = "是否组组里的最后一轮")
    private String isLast;


}
