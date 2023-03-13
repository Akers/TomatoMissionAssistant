package com.github.akers.tma.service;

import com.github.akers.tma.domain.TmaMissionAssigned;
import com.github.akers.tma.domain.vo.TmaMissionAssignedVo;
import com.github.akers.tma.domain.bo.TmaMissionAssignedBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 任务指派Service接口
 *
 * @author ruoyi
 * @date 2023-03-01
 */
public interface ITmaMissionAssignedService {

    /**
     * 查询任务指派
     */
    TmaMissionAssignedVo queryById(Long id);

    /**
     * 查询任务指派列表
     */
    TableDataInfo<TmaMissionAssignedVo> queryPageList(TmaMissionAssignedBo bo, PageQuery pageQuery);

    /**
     * 查询任务指派列表
     */
    List<TmaMissionAssignedVo> queryList(TmaMissionAssignedBo bo);

    /**
     * 新增任务指派
     */
    Boolean insertByBo(TmaMissionAssignedBo bo);

    /**
     * 修改任务指派
     */
    Boolean updateByBo(TmaMissionAssignedBo bo);

    /**
     * 校验并批量删除任务指派信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
