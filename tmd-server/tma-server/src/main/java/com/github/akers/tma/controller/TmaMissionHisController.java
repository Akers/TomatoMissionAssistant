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
import com.github.akers.tma.domain.vo.TmaMissionHisVo;
import com.github.akers.tma.domain.bo.TmaMissionHisBo;
import com.github.akers.tma.service.ITmaMissionHisService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务历史
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tmaserver/missionHis")
public class TmaMissionHisController extends BaseController {

    private final ITmaMissionHisService iTmaMissionHisService;

    /**
     * 查询任务历史列表
     */
    @SaCheckPermission("tmaserver:missionHis:list")
    @GetMapping("/list")
    public TableDataInfo<TmaMissionHisVo> list(TmaMissionHisBo bo, PageQuery pageQuery) {
        return iTmaMissionHisService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出任务历史列表
     */
    @SaCheckPermission("tmaserver:missionHis:export")
    @Log(title = "任务历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TmaMissionHisBo bo, HttpServletResponse response) {
        List<TmaMissionHisVo> list = iTmaMissionHisService.queryList(bo);
        ExcelUtil.exportExcel(list, "任务历史", TmaMissionHisVo.class, response);
    }

    /**
     * 获取任务历史详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tmaserver:missionHis:query")
    @GetMapping("/{id}")
    public R<TmaMissionHisVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iTmaMissionHisService.queryById(id));
    }

    /**
     * 新增任务历史
     */
    @SaCheckPermission("tmaserver:missionHis:add")
    @Log(title = "任务历史", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TmaMissionHisBo bo) {
        return toAjax(iTmaMissionHisService.insertByBo(bo));
    }

    /**
     * 修改任务历史
     */
    @SaCheckPermission("tmaserver:missionHis:edit")
    @Log(title = "任务历史", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TmaMissionHisBo bo) {
        return toAjax(iTmaMissionHisService.updateByBo(bo));
    }

    /**
     * 删除任务历史
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tmaserver:missionHis:remove")
    @Log(title = "任务历史", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iTmaMissionHisService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
