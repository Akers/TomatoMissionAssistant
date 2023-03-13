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
import com.github.akers.tma.domain.vo.TmaTomatoGroupVo;
import com.github.akers.tma.domain.bo.TmaTomatoGroupBo;
import com.github.akers.tma.service.ITmaTomatoGroupService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 番茄组
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tmaserver/tomatoGroup")
public class TmaTomatoGroupController extends BaseController {

    private final ITmaTomatoGroupService iTmaTomatoGroupService;

    /**
     * 查询番茄组列表
     */
    @SaCheckPermission("tmaserver:tomatoGroup:list")
    @GetMapping("/list")
    public TableDataInfo<TmaTomatoGroupVo> list(TmaTomatoGroupBo bo, PageQuery pageQuery) {
        return iTmaTomatoGroupService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出番茄组列表
     */
    @SaCheckPermission("tmaserver:tomatoGroup:export")
    @Log(title = "番茄组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TmaTomatoGroupBo bo, HttpServletResponse response) {
        List<TmaTomatoGroupVo> list = iTmaTomatoGroupService.queryList(bo);
        ExcelUtil.exportExcel(list, "番茄组", TmaTomatoGroupVo.class, response);
    }

    /**
     * 获取番茄组详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tmaserver:tomatoGroup:query")
    @GetMapping("/{id}")
    public R<TmaTomatoGroupVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iTmaTomatoGroupService.queryById(id));
    }

    /**
     * 新增番茄组
     */
    @SaCheckPermission("tmaserver:tomatoGroup:add")
    @Log(title = "番茄组", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TmaTomatoGroupBo bo) {
        return toAjax(iTmaTomatoGroupService.insertByBo(bo));
    }

    /**
     * 修改番茄组
     */
    @SaCheckPermission("tmaserver:tomatoGroup:edit")
    @Log(title = "番茄组", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TmaTomatoGroupBo bo) {
        return toAjax(iTmaTomatoGroupService.updateByBo(bo));
    }

    /**
     * 删除番茄组
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tmaserver:tomatoGroup:remove")
    @Log(title = "番茄组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iTmaTomatoGroupService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
