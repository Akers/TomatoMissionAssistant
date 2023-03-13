package com.github.akers.tma.service;

import com.github.akers.tma.domain.TmaMissionHis;
import com.github.akers.tma.domain.vo.TmaMissionHisVo;
import com.github.akers.tma.domain.bo.TmaMissionHisBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 任务历史Service接口
 *
 * @author ruoyi
 * @date 2023-03-01
 */
public interface ITmaMissionHisService {

    /**
     * 查询任务历史
     */
    TmaMissionHisVo queryById(Long id);

    /**
     * 查询任务历史列表
     */
    TableDataInfo<TmaMissionHisVo> queryPageList(TmaMissionHisBo bo, PageQuery pageQuery);

    /**
     * 查询任务历史列表
     */
    List<TmaMissionHisVo> queryList(TmaMissionHisBo bo);

    /**
     * 新增任务历史
     */
    Boolean insertByBo(TmaMissionHisBo bo);

    /**
     * 修改任务历史
     */
    Boolean updateByBo(TmaMissionHisBo bo);

    /**
     * 校验并批量删除任务历史信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
