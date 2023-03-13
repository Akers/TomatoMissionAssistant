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
import com.github.akers.tma.domain.vo.TmaMissionAssignedVo;
import com.github.akers.tma.domain.bo.TmaMissionAssignedBo;
import com.github.akers.tma.service.ITmaMissionAssignedService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务指派
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tmaserver/missionAssigned")
public class TmaMissionAssignedController extends BaseController {

    private final ITmaMissionAssignedService iTmaMissionAssignedService;

    /**
     * 查询任务指派列表
     */
    @SaCheckPermission("tmaserver:missionAssigned:list")
    @GetMapping("/list")
    public TableDataInfo<TmaMissionAssignedVo> list(TmaMissionAssignedBo bo, PageQuery pageQuery) {
        return iTmaMissionAssignedService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出任务指派列表
     */
    @SaCheckPermission("tmaserver:missionAssigned:export")
    @Log(title = "任务指派", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TmaMissionAssignedBo bo, HttpServletResponse response) {
        List<TmaMissionAssignedVo> list = iTmaMissionAssignedService.queryList(bo);
        ExcelUtil.exportExcel(list, "任务指派", TmaMissionAssignedVo.class, response);
    }

    /**
     * 获取任务指派详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tmaserver:missionAssigned:query")
    @GetMapping("/{id}")
    public R<TmaMissionAssignedVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iTmaMissionAssignedService.queryById(id));
    }

    /**
     * 新增任务指派
     */
    @SaCheckPermission("tmaserver:missionAssigned:add")
    @Log(title = "任务指派", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TmaMissionAssignedBo bo) {
        return toAjax(iTmaMissionAssignedService.insertByBo(bo));
    }

    /**
     * 修改任务指派
     */
    @SaCheckPermission("tmaserver:missionAssigned:edit")
    @Log(title = "任务指派", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TmaMissionAssignedBo bo) {
        return toAjax(iTmaMissionAssignedService.updateByBo(bo));
    }

    /**
     * 删除任务指派
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tmaserver:missionAssigned:remove")
    @Log(title = "任务指派", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iTmaMissionAssignedService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
