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
import com.github.akers.tma.domain.bo.TmaMissionAssignedBo;
import com.github.akers.tma.domain.vo.TmaMissionAssignedVo;
import com.github.akers.tma.domain.TmaMissionAssigned;
import com.github.akers.tma.mapper.TmaMissionAssignedMapper;
import com.github.akers.tma.service.ITmaMissionAssignedService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 任务指派Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@RequiredArgsConstructor
@Service
public class TmaMissionAssignedServiceImpl implements ITmaMissionAssignedService {

    private final TmaMissionAssignedMapper baseMapper;

    /**
     * 查询任务指派
     */
    @Override
    public TmaMissionAssignedVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询任务指派列表
     */
    @Override
    public TableDataInfo<TmaMissionAssignedVo> queryPageList(TmaMissionAssignedBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<TmaMissionAssigned> lqw = buildQueryWrapper(bo);
        Page<TmaMissionAssignedVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询任务指派列表
     */
    @Override
    public List<TmaMissionAssignedVo> queryList(TmaMissionAssignedBo bo) {
        LambdaQueryWrapper<TmaMissionAssigned> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TmaMissionAssigned> buildQueryWrapper(TmaMissionAssignedBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TmaMissionAssigned> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getUserId()), TmaMissionAssigned::getUserId, bo.getUserId());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionId()), TmaMissionAssigned::getMissionId, bo.getMissionId());
        lqw.eq(StringUtils.isNotBlank(bo.getAssignTime()), TmaMissionAssigned::getAssignTime, bo.getAssignTime());
        return lqw;
    }

    /**
     * 新增任务指派
     */
    @Override
    public Boolean insertByBo(TmaMissionAssignedBo bo) {
        TmaMissionAssigned add = BeanUtil.toBean(bo, TmaMissionAssigned.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改任务指派
     */
    @Override
    public Boolean updateByBo(TmaMissionAssignedBo bo) {
        TmaMissionAssigned update = BeanUtil.toBean(bo, TmaMissionAssigned.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(TmaMissionAssigned entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除任务指派
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
