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
import com.github.akers.tma.domain.bo.TmaInterruptBo;
import com.github.akers.tma.domain.vo.TmaInterruptVo;
import com.github.akers.tma.domain.TmaInterrupt;
import com.github.akers.tma.mapper.TmaInterruptMapper;
import com.github.akers.tma.service.ITmaInterruptService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 中断Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@RequiredArgsConstructor
@Service
public class TmaInterruptServiceImpl implements ITmaInterruptService {

    private final TmaInterruptMapper baseMapper;

    /**
     * 查询中断
     */
    @Override
    public TmaInterruptVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询中断列表
     */
    @Override
    public TableDataInfo<TmaInterruptVo> queryPageList(TmaInterruptBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<TmaInterrupt> lqw = buildQueryWrapper(bo);
        Page<TmaInterruptVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询中断列表
     */
    @Override
    public List<TmaInterruptVo> queryList(TmaInterruptBo bo) {
        LambdaQueryWrapper<TmaInterrupt> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TmaInterrupt> buildQueryWrapper(TmaInterruptBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TmaInterrupt> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getUserId()), TmaInterrupt::getUserId, bo.getUserId());
        lqw.eq(StringUtils.isNotBlank(bo.getTomatoId()), TmaInterrupt::getTomatoId, bo.getTomatoId());
        lqw.eq(bo.getStartTime() != null, TmaInterrupt::getStartTime, bo.getStartTime());
        lqw.eq(bo.getEndTime() != null, TmaInterrupt::getEndTime, bo.getEndTime());
        lqw.eq(bo.getInterruptedTime() != null, TmaInterrupt::getInterruptedTime, bo.getInterruptedTime());
        lqw.eq(StringUtils.isNotBlank(bo.getInterruptType()), TmaInterrupt::getInterruptType, bo.getInterruptType());
        return lqw;
    }

    /**
     * 新增中断
     */
    @Override
    public Boolean insertByBo(TmaInterruptBo bo) {
        TmaInterrupt add = BeanUtil.toBean(bo, TmaInterrupt.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改中断
     */
    @Override
    public Boolean updateByBo(TmaInterruptBo bo) {
        TmaInterrupt update = BeanUtil.toBean(bo, TmaInterrupt.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(TmaInterrupt entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除中断
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
