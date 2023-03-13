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
import com.github.akers.tma.domain.bo.TmaTomatoGroupBo;
import com.github.akers.tma.domain.vo.TmaTomatoGroupVo;
import com.github.akers.tma.domain.TmaTomatoGroup;
import com.github.akers.tma.mapper.TmaTomatoGroupMapper;
import com.github.akers.tma.service.ITmaTomatoGroupService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 番茄组Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@RequiredArgsConstructor
@Service
public class TmaTomatoGroupServiceImpl implements ITmaTomatoGroupService {

    private final TmaTomatoGroupMapper baseMapper;

    /**
     * 查询番茄组
     */
    @Override
    public TmaTomatoGroupVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询番茄组列表
     */
    @Override
    public TableDataInfo<TmaTomatoGroupVo> queryPageList(TmaTomatoGroupBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<TmaTomatoGroup> lqw = buildQueryWrapper(bo);
        Page<TmaTomatoGroupVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询番茄组列表
     */
    @Override
    public List<TmaTomatoGroupVo> queryList(TmaTomatoGroupBo bo) {
        LambdaQueryWrapper<TmaTomatoGroup> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TmaTomatoGroup> buildQueryWrapper(TmaTomatoGroupBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TmaTomatoGroup> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getBreakTime() != null, TmaTomatoGroup::getBreakTime, bo.getBreakTime());
        lqw.eq(bo.getTomatoes() != null, TmaTomatoGroup::getTomatoes, bo.getTomatoes());
        lqw.eq(StringUtils.isNotBlank(bo.getUserId()), TmaTomatoGroup::getUserId, bo.getUserId());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionId()), TmaTomatoGroup::getMissionId, bo.getMissionId());
        return lqw;
    }

    /**
     * 新增番茄组
     */
    @Override
    public Boolean insertByBo(TmaTomatoGroupBo bo) {
        TmaTomatoGroup add = BeanUtil.toBean(bo, TmaTomatoGroup.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改番茄组
     */
    @Override
    public Boolean updateByBo(TmaTomatoGroupBo bo) {
        TmaTomatoGroup update = BeanUtil.toBean(bo, TmaTomatoGroup.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(TmaTomatoGroup entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除番茄组
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
