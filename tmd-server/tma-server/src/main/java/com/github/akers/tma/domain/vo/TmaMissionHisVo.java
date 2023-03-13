package com.github.akers.tma.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 任务历史视图对象 tma_mission_his
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@ExcelIgnoreUnannotated
public class TmaMissionHisVo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 团队id
     */
    @ExcelProperty(value = "团队id")
    private String teamId;

    /**
     * 任务预估工期（小时）
     */
    @ExcelProperty(value = "任务预估工期", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "小=时")
    private Long missionDuration;

    /**
     * 任务名称
     */
    @ExcelProperty(value = "任务名称")
    private String missionName;

    /**
     * 任务类型
     */
    @ExcelProperty(value = "任务类型")
    private String missionType;

    /**
     * 任务状态
     */
    @ExcelProperty(value = "任务状态")
    private String missionStatus;

    /**
     * 任务描述
     */
    @ExcelProperty(value = "任务描述")
    private String missionDesc;

    /**
     * 父级任务id
     */
    @ExcelProperty(value = "父级任务id")
    private String parentId;

    /**
     * 任务ID;创建任务时生成，修改任务时不变
     */
    @ExcelProperty(value = "任务ID;创建任务时生成，修改任务时不变")
    private String missionId;


}
