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
import com.github.akers.tma.domain.bo.TmaMissionBo;
import com.github.akers.tma.domain.vo.TmaMissionVo;
import com.github.akers.tma.domain.TmaMission;
import com.github.akers.tma.mapper.TmaMissionMapper;
import com.github.akers.tma.service.ITmaMissionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 任务Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@RequiredArgsConstructor
@Service
public class TmaMissionServiceImpl implements ITmaMissionService {

    private final TmaMissionMapper baseMapper;

    /**
     * 查询任务
     */
    @Override
    public TmaMissionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询任务列表
     */
    @Override
    public TableDataInfo<TmaMissionVo> queryPageList(TmaMissionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<TmaMission> lqw = buildQueryWrapper(bo);
        Page<TmaMissionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询任务列表
     */
    @Override
    public List<TmaMissionVo> queryList(TmaMissionBo bo) {
        LambdaQueryWrapper<TmaMission> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TmaMission> buildQueryWrapper(TmaMissionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TmaMission> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getTeamId()), TmaMission::getTeamId, bo.getTeamId());
        lqw.eq(bo.getMissionDuration() != null, TmaMission::getMissionDuration, bo.getMissionDuration());
        lqw.like(StringUtils.isNotBlank(bo.getMissionName()), TmaMission::getMissionName, bo.getMissionName());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionType()), TmaMission::getMissionType, bo.getMissionType());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionStatus()), TmaMission::getMissionStatus, bo.getMissionStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionDesc()), TmaMission::getMissionDesc, bo.getMissionDesc());
        lqw.eq(StringUtils.isNotBlank(bo.getParentId()), TmaMission::getParentId, bo.getParentId());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionId()), TmaMission::getMissionId, bo.getMissionId());
        return lqw;
    }

    /**
     * 新增任务
     */
    @Override
    public Boolean insertByBo(TmaMissionBo bo) {
        TmaMission add = BeanUtil.toBean(bo, TmaMission.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改任务
     */
    @Override
    public Boolean updateByBo(TmaMissionBo bo) {
        TmaMission update = BeanUtil.toBean(bo, TmaMission.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(TmaMission entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除任务
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
