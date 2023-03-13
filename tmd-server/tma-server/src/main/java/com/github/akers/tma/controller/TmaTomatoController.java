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
import com.github.akers.tma.domain.vo.TmaTomatoVo;
import com.github.akers.tma.domain.bo.TmaTomatoBo;
import com.github.akers.tma.service.ITmaTomatoService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 番茄计时
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tmaserver/tomato")
public class TmaTomatoController extends BaseController {

    private final ITmaTomatoService iTmaTomatoService;

    /**
     * 查询番茄计时列表
     */
    @SaCheckPermission("tmaserver:tomato:list")
    @GetMapping("/list")
    public TableDataInfo<TmaTomatoVo> list(TmaTomatoBo bo, PageQuery pageQuery) {
        return iTmaTomatoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出番茄计时列表
     */
    @SaCheckPermission("tmaserver:tomato:export")
    @Log(title = "番茄计时", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TmaTomatoBo bo, HttpServletResponse response) {
        List<TmaTomatoVo> list = iTmaTomatoService.queryList(bo);
        ExcelUtil.exportExcel(list, "番茄计时", TmaTomatoVo.class, response);
    }

    /**
     * 获取番茄计时详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tmaserver:tomato:query")
    @GetMapping("/{id}")
    public R<TmaTomatoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iTmaTomatoService.queryById(id));
    }

    /**
     * 新增番茄计时
     */
    @SaCheckPermission("tmaserver:tomato:add")
    @Log(title = "番茄计时", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TmaTomatoBo bo) {
        return toAjax(iTmaTomatoService.insertByBo(bo));
    }

    /**
     * 修改番茄计时
     */
    @SaCheckPermission("tmaserver:tomato:edit")
    @Log(title = "番茄计时", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TmaTomatoBo bo) {
        return toAjax(iTmaTomatoService.updateByBo(bo));
    }

    /**
     * 删除番茄计时
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tmaserver:tomato:remove")
    @Log(title = "番茄计时", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iTmaTomatoService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
