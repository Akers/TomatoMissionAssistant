package com.github.akers.tma.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.github.akers.tma.domain.bo.TmaTomatoBo;
import com.github.akers.tma.domain.vo.TmaTomatoVo;
import com.github.akers.tma.domain.TmaTomato;
import com.github.akers.tma.mapper.TmaTomatoMapper;
import com.github.akers.tma.service.ITmaTomatoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 番茄计时Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@RequiredArgsConstructor
@Service
public class TmaTomatoServiceImpl implements ITmaTomatoService {

    private final TmaTomatoMapper baseMapper;

    /**
     * 查询番茄计时
     */
    @Override
    public TmaTomatoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询番茄计时列表
     */
    @Override
    public TableDataInfo<TmaTomatoVo> queryPageList(TmaTomatoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<TmaTomato> lqw = buildQueryWrapper(bo);
        Page<TmaTomatoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询番茄计时列表
     */
    @Override
    public List<TmaTomatoVo> queryList(TmaTomatoBo bo) {
        LambdaQueryWrapper<TmaTomato> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TmaTomato> buildQueryWrapper(TmaTomatoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TmaTomato> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getGroupId()), TmaTomato::getGroupId, bo.getGroupId());
        lqw.eq(StringUtils.isNotBlank(bo.getUserId()), TmaTomato::getUserId, bo.getUserId());
        lqw.eq(bo.getFocusTime() != null, TmaTomato::getFocusTime, bo.getFocusTime());
        lqw.eq(bo.getSort() != null, TmaTomato::getSort, bo.getSort());
        lqw.eq(bo.getBreakTime() != null, TmaTomato::getBreakTime, bo.getBreakTime());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionId()), TmaTomato::getMissionId, bo.getMissionId());
        lqw.eq(StringUtils.isNotBlank(bo.getBreakType()), TmaTomato::getBreakType, bo.getBreakType());
        lqw.eq(StringUtils.isNotBlank(bo.getTomatoConfigId()), TmaTomato::getTomatoConfigId, bo.getTomatoConfigId());
        lqw.eq(bo.getFocusTimeCofniged() != null, TmaTomato::getFocusTimeCofniged, bo.getFocusTimeCofniged());
        lqw.eq(bo.getBreakTimeConfiged() != null, TmaTomato::getBreakTimeConfiged, bo.getBreakTimeConfiged());
        lqw.eq(StringUtils.isNotBlank(bo.getIsLast()), TmaTomato::getIsLast, bo.getIsLast());
        return lqw;
    }

    /**
     * 新增番茄计时
     */
    @Override
    public Boolean insertByBo(TmaTomatoBo bo) {
        TmaTomato add = BeanUtil.toBean(bo, TmaTomato.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改番茄计时
     */
    @Override
    public Boolean updateByBo(TmaTomatoBo bo) {
        TmaTomato update = BeanUtil.toBean(bo, TmaTomato.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(TmaTomato entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除番茄计时
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
