package com.github.akers.tma.service;

import com.github.akers.tma.domain.TmaTomato;
import com.github.akers.tma.domain.vo.TmaTomatoVo;
import com.github.akers.tma.domain.bo.TmaTomatoBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 番茄计时Service接口
 *
 * @author ruoyi
 * @date 2023-03-01
 */
public interface ITmaTomatoService {

    /**
     * 查询番茄计时
     */
    TmaTomatoVo queryById(Long id);

    /**
     * 查询番茄计时列表
     */
    TableDataInfo<TmaTomatoVo> queryPageList(TmaTomatoBo bo, PageQuery pageQuery);

    /**
     * 查询番茄计时列表
     */
    List<TmaTomatoVo> queryList(TmaTomatoBo bo);

    /**
     * 新增番茄计时
     */
    Boolean insertByBo(TmaTomatoBo bo);

    /**
     * 修改番茄计时
     */
    Boolean updateByBo(TmaTomatoBo bo);

    /**
     * 校验并批量删除番茄计时信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
