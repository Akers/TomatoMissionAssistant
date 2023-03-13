package com.github.akers.tma.service;

import com.github.akers.tma.domain.TmaMission;
import com.github.akers.tma.domain.vo.TmaMissionVo;
import com.github.akers.tma.domain.bo.TmaMissionBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 任务Service接口
 *
 * @author ruoyi
 * @date 2023-03-01
 */
public interface ITmaMissionService {

    /**
     * 查询任务
     */
    TmaMissionVo queryById(Long id);

    /**
     * 查询任务列表
     */
    TableDataInfo<TmaMissionVo> queryPageList(TmaMissionBo bo, PageQuery pageQuery);

    /**
     * 查询任务列表
     */
    List<TmaMissionVo> queryList(TmaMissionBo bo);

    /**
     * 新增任务
     */
    Boolean insertByBo(TmaMissionBo bo);

    /**
     * 修改任务
     */
    Boolean updateByBo(TmaMissionBo bo);

    /**
     * 校验并批量删除任务信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
