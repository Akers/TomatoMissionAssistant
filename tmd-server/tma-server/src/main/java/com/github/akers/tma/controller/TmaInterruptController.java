package com.github.akers.tma.controller;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.github.akers.tma.domain.vo.TmaInterruptVo;
import com.github.akers.tma.domain.bo.TmaInterruptBo;
import com.github.akers.tma.service.ITmaInterruptService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 中断
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tmaserver/interrupt")
public class TmaInterruptController extends BaseController {

    private final ITmaInterruptService iTmaInterruptService;

    /**
     * 查询中断列表
     */
    @SaCheckPermission("tmaserver:interrupt:list")
    @GetMapping("/list")
    public TableDataInfo<TmaInterruptVo> list(TmaInterruptBo bo, PageQuery pageQuery) {
        return iTmaInterruptService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出中断列表
     */
    @SaCheckPermission("tmaserver:interrupt:export")
    @Log(title = "中断", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TmaInterruptBo bo, HttpServletResponse response) {
        List<TmaInterruptVo> list = iTmaInterruptService.queryList(bo);
        ExcelUtil.exportExcel(list, "中断", TmaInterruptVo.class, response);
    }

    /**
     * 获取中断详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tmaserver:interrupt:query")
    @GetMapping("/{id}")
    public R<TmaInterruptVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iTmaInterruptService.queryById(id));
    }

    /**
     * 新增中断
     */
    @SaCheckPermission("tmaserver:interrupt:add")
    @Log(title = "中断", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TmaInterruptBo bo) {
        return toAjax(iTmaInterruptService.insertByBo(bo));
    }

    /**
     * 修改中断
     */
    @SaCheckPermission("tmaserver:interrupt:edit")
    @Log(title = "中断", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TmaInterruptBo bo) {
        return toAjax(iTmaInterruptService.updateByBo(bo));
    }

    /**
     * 删除中断
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tmaserver:interrupt:remove")
    @Log(title = "中断", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iTmaInterruptService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
