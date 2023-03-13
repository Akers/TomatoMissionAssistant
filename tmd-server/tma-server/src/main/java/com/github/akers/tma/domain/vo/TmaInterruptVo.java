package com.github.akers.tma.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 中断视图对象 tma_interrupt
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@ExcelIgnoreUnannotated
public class TmaInterruptVo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    private String userId;

    /**
     * 中断关联的番茄id
     */
    @ExcelProperty(value = "中断关联的番茄id")
    private String tomatoId;

    /**
     * 中断开始时间
     */
    @ExcelProperty(value = "中断开始时间")
    private Date startTime;

    /**
     * 中断结束时间
     */
    @ExcelProperty(value = "中断结束时间")
    private Date endTime;

    /**
     * 中断时长
     */
    @ExcelProperty(value = "中断时长")
    private Long interruptedTime;

    /**
     * 中断类型;1--专注工作中断；2--短休息中断；3--长休息中断
     */
    @ExcelProperty(value = "中断类型;1--专注工作中断；2--短休息中断；3--长休息中断")
    private String interruptType;


}
