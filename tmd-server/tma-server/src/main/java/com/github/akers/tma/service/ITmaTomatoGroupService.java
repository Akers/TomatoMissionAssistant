package com.github.akers.tma.service;

import com.github.akers.tma.domain.TmaTomatoGroup;
import com.github.akers.tma.domain.vo.TmaTomatoGroupVo;
import com.github.akers.tma.domain.bo.TmaTomatoGroupBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 番茄组Service接口
 *
 * @author ruoyi
 * @date 2023-03-01
 */
public interface ITmaTomatoGroupService {

    /**
     * 查询番茄组
     */
    TmaTomatoGroupVo queryById(Long id);

    /**
     * 查询番茄组列表
     */
    TableDataInfo<TmaTomatoGroupVo> queryPageList(TmaTomatoGroupBo bo, PageQuery pageQuery);

    /**
     * 查询番茄组列表
     */
    List<TmaTomatoGroupVo> queryList(TmaTomatoGroupBo bo);

    /**
     * 新增番茄组
     */
    Boolean insertByBo(TmaTomatoGroupBo bo);

    /**
     * 修改番茄组
     */
    Boolean updateByBo(TmaTomatoGroupBo bo);

    /**
     * 校验并批量删除番茄组信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
