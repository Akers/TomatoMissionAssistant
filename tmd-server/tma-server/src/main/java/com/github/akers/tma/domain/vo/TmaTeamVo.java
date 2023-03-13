package com.github.akers.tma.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 团队视图对象 tma_team
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Data
@ExcelIgnoreUnannotated
public class TmaTeamVo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 团队名称
     */
    @ExcelProperty(value = "团队名称")
    private String teamName;

    /**
     * 机构id
     */
    @ExcelProperty(value = "机构id")
    private String deptId;

    /**
     * 团队介绍
     */
    @ExcelProperty(value = "团队介绍")
    private String teamDesc;


}
