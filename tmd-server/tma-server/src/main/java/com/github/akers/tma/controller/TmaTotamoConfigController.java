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
import com.github.akers.tma.domain.vo.TmaTotamoConfigVo;
import com.github.akers.tma.domain.bo.TmaTotamoConfigBo;
import com.github.akers.tma.service.ITmaTotamoConfigService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 番茄配置
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tmaserver/totamoConfig")
public class TmaTotamoConfigController extends BaseController {

    private final ITmaTotamoConfigService iTmaTotamoConfigService;

    /**
     * 查询番茄配置列表
     */
    @SaCheckPermission("tmaserver:totamoConfig:list")
    @GetMapping("/list")
    public TableDataInfo<TmaTotamoConfigVo> list(TmaTotamoConfigBo bo, PageQuery pageQuery) {
        return iTmaTotamoConfigService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出番茄配置列表
     */
    @SaCheckPermission("tmaserver:totamoConfig:export")
    @Log(title = "番茄配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TmaTotamoConfigBo bo, HttpServletResponse response) {
        List<TmaTotamoConfigVo> list = iTmaTotamoConfigService.queryList(bo);
        ExcelUtil.exportExcel(list, "番茄配置", TmaTotamoConfigVo.class, response);
    }

    /**
     * 获取番茄配置详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tmaserver:totamoConfig:query")
    @GetMapping("/{id}")
    public R<TmaTotamoConfigVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iTmaTotamoConfigService.queryById(id));
    }

    /**
     * 新增番茄配置
     */
    @SaCheckPermission("tmaserver:totamoConfig:add")
    @Log(title = "番茄配置", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TmaTotamoConfigBo bo) {
        return toAjax(iTmaTotamoConfigService.insertByBo(bo));
    }

    /**
     * 修改番茄配置
     */
    @SaCheckPermission("tmaserver:totamoConfig:edit")
    @Log(title = "番茄配置", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TmaTotamoConfigBo bo) {
        return toAjax(iTmaTotamoConfigService.updateByBo(bo));
    }

    /**
     * 删除番茄配置
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tmaserver:totamoConfig:remove")
    @Log(title = "番茄配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iTmaTotamoConfigService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
