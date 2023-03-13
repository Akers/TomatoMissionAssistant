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
import com.github.akers.tma.domain.bo.TmaMissionHisBo;
import com.github.akers.tma.domain.vo.TmaMissionHisVo;
import com.github.akers.tma.domain.TmaMissionHis;
import com.github.akers.tma.mapper.TmaMissionHisMapper;
import com.github.akers.tma.service.ITmaMissionHisService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 任务历史Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@RequiredArgsConstructor
@Service
public class TmaMissionHisServiceImpl implements ITmaMissionHisService {

    private final TmaMissionHisMapper baseMapper;

    /**
     * 查询任务历史
     */
    @Override
    public TmaMissionHisVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询任务历史列表
     */
    @Override
    public TableDataInfo<TmaMissionHisVo> queryPageList(TmaMissionHisBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<TmaMissionHis> lqw = buildQueryWrapper(bo);
        Page<TmaMissionHisVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询任务历史列表
     */
    @Override
    public List<TmaMissionHisVo> queryList(TmaMissionHisBo bo) {
        LambdaQueryWrapper<TmaMissionHis> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TmaMissionHis> buildQueryWrapper(TmaMissionHisBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TmaMissionHis> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getTeamId()), TmaMissionHis::getTeamId, bo.getTeamId());
        lqw.eq(bo.getMissionDuration() != null, TmaMissionHis::getMissionDuration, bo.getMissionDuration());
        lqw.like(StringUtils.isNotBlank(bo.getMissionName()), TmaMissionHis::getMissionName, bo.getMissionName());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionType()), TmaMissionHis::getMissionType, bo.getMissionType());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionStatus()), TmaMissionHis::getMissionStatus, bo.getMissionStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionDesc()), TmaMissionHis::getMissionDesc, bo.getMissionDesc());
        lqw.eq(StringUtils.isNotBlank(bo.getParentId()), TmaMissionHis::getParentId, bo.getParentId());
        lqw.eq(StringUtils.isNotBlank(bo.getMissionId()), TmaMissionHis::getMissionId, bo.getMissionId());
        return lqw;
    }

    /**
     * 新增任务历史
     */
    @Override
    public Boolean insertByBo(TmaMissionHisBo bo) {
        TmaMissionHis add = BeanUtil.toBean(bo, TmaMissionHis.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改任务历史
     */
    @Override
    public Boolean updateByBo(TmaMissionHisBo bo) {
        TmaMissionHis update = BeanUtil.toBean(bo, TmaMissionHis.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(TmaMissionHis entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除任务历史
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
