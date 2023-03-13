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
import com.github.akers.tma.domain.bo.TmaTeamBo;
import com.github.akers.tma.domain.vo.TmaTeamVo;
import com.github.akers.tma.domain.TmaTeam;
import com.github.akers.tma.mapper.TmaTeamMapper;
import com.github.akers.tma.service.ITmaTeamService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 团队Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@RequiredArgsConstructor
@Service
public class TmaTeamServiceImpl implements ITmaTeamService {

    private final TmaTeamMapper baseMapper;

    /**
     * 查询团队
     */
    @Override
    public TmaTeamVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询团队列表
     */
    @Override
    public TableDataInfo<TmaTeamVo> queryPageList(TmaTeamBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<TmaTeam> lqw = buildQueryWrapper(bo);
        Page<TmaTeamVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询团队列表
     */
    @Override
    public List<TmaTeamVo> queryList(TmaTeamBo bo) {
        LambdaQueryWrapper<TmaTeam> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TmaTeam> buildQueryWrapper(TmaTeamBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TmaTeam> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getTeamName()), TmaTeam::getTeamName, bo.getTeamName());
        lqw.eq(StringUtils.isNotBlank(bo.getDeptId()), TmaTeam::getDeptId, bo.getDeptId());
        lqw.eq(StringUtils.isNotBlank(bo.getTeamDesc()), TmaTeam::getTeamDesc, bo.getTeamDesc());
        return lqw;
    }

    /**
     * 新增团队
     */
    @Override
    public Boolean insertByBo(TmaTeamBo bo) {
        TmaTeam add = BeanUtil.toBean(bo, TmaTeam.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改团队
     */
    @Override
    public Boolean updateByBo(TmaTeamBo bo) {
        TmaTeam update = BeanUtil.toBean(bo, TmaTeam.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(TmaTeam entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除团队
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
