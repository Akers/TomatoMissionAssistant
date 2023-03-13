package com.github.akers.tma.service;

import com.github.akers.tma.domain.TmaInterrupt;
import com.github.akers.tma.domain.vo.TmaInterruptVo;
import com.github.akers.tma.domain.bo.TmaInterruptBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 中断Service接口
 *
 * @author ruoyi
 * @date 2023-03-01
 */
public interface ITmaInterruptService {

    /**
     * 查询中断
     */
    TmaInterruptVo queryById(Long id);

    /**
     * 查询中断列表
     */
    TableDataInfo<TmaInterruptVo> queryPageList(TmaInterruptBo bo, PageQuery pageQuery);

    /**
     * 查询中断列表
     */
    List<TmaInterruptVo> queryList(TmaInterruptBo bo);

    /**
     * 新增中断
     */
    Boolean insertByBo(TmaInterruptBo bo);

    /**
     * 修改中断
     */
    Boolean updateByBo(TmaInterruptBo bo);

    /**
     * 校验并批量删除中断信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
