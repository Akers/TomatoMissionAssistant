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
import com.github.akers.tma.domain.vo.TmaMissionVo;
import com.github.akers.tma.domain.bo.TmaMissionBo;
import com.github.akers.tma.service.ITmaMissionService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tmaserver/mission")
public class TmaMissionController extends BaseController {

    private final ITmaMissionService iTmaMissionService;

    /**
     * 查询任务列表
     */
    @SaCheckPermission("tmaserver:mission:list")
    @GetMapping("/list")
    public TableDataInfo<TmaMissionVo> list(TmaMissionBo bo, PageQuery pageQuery) {
        return iTmaMissionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出任务列表
     */
    @SaCheckPermission("tmaserver:mission:export")
    @Log(title = "任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TmaMissionBo bo, HttpServletResponse response) {
        List<TmaMissionVo> list = iTmaMissionService.queryList(bo);
        ExcelUtil.exportExcel(list, "任务", TmaMissionVo.class, response);
    }

    /**
     * 获取任务详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tmaserver:mission:query")
    @GetMapping("/{id}")
    public R<TmaMissionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iTmaMissionService.queryById(id));
    }

    /**
     * 新增任务
     */
    @SaCheckPermission("tmaserver:mission:add")
    @Log(title = "任务", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TmaMissionBo bo) {
        return toAjax(iTmaMissionService.insertByBo(bo));
    }

    /**
     * 修改任务
     */
    @SaCheckPermission("tmaserver:mission:edit")
    @Log(title = "任务", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TmaMissionBo bo) {
        return toAjax(iTmaMissionService.updateByBo(bo));
    }

    /**
     * 删除任务
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tmaserver:mission:remove")
    @Log(title = "任务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iTmaMissionService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
