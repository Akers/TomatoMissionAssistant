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
import com.github.akers.tma.domain.vo.TmaTeamVo;
import com.github.akers.tma.domain.bo.TmaTeamBo;
import com.github.akers.tma.service.ITmaTeamService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 团队
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tmaserver/team")
public class TmaTeamController extends BaseController {

    private final ITmaTeamService iTmaTeamService;

    /**
     * 查询团队列表
     */
    @SaCheckPermission("tmaserver:team:list")
    @GetMapping("/list")
    public TableDataInfo<TmaTeamVo> list(TmaTeamBo bo, PageQuery pageQuery) {
        return iTmaTeamService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出团队列表
     */
    @SaCheckPermission("tmaserver:team:export")
    @Log(title = "团队", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TmaTeamBo bo, HttpServletResponse response) {
        List<TmaTeamVo> list = iTmaTeamService.queryList(bo);
        ExcelUtil.exportExcel(list, "团队", TmaTeamVo.class, response);
    }

    /**
     * 获取团队详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tmaserver:team:query")
    @GetMapping("/{id}")
    public R<TmaTeamVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iTmaTeamService.queryById(id));
    }

    /**
     * 新增团队
     */
    @SaCheckPermission("tmaserver:team:add")
    @Log(title = "团队", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody TmaTeamBo bo) {
        return toAjax(iTmaTeamService.insertByBo(bo));
    }

    /**
     * 修改团队
     */
    @SaCheckPermission("tmaserver:team:edit")
    @Log(title = "团队", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody TmaTeamBo bo) {
        return toAjax(iTmaTeamService.updateByBo(bo));
    }

    /**
     * 删除团队
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tmaserver:team:remove")
    @Log(title = "团队", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iTmaTeamService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
