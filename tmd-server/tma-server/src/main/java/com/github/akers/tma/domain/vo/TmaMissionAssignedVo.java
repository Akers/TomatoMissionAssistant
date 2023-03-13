package com.github.akers.tma.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 任务指派视图对象 tma_mission_assigned
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@ExcelIgnoreUnannotated
public class TmaMissionAssignedVo {

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
     * 任务ID;tmd_mission表的mission_id
     */
    @ExcelProperty(value = "任务ID;tmd_mission表的mission_id")
    private String missionId;

    /**
     * 指派时间;指派任务时间
     */
    @ExcelProperty(value = "指派时间;指派任务时间")
    private String assignTime;


}
