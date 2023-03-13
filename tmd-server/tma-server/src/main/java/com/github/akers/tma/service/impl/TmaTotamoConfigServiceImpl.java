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
import com.github.akers.tma.domain.bo.TmaTotamoConfigBo;
import com.github.akers.tma.domain.vo.TmaTotamoConfigVo;
import com.github.akers.tma.domain.TmaTotamoConfig;
import com.github.akers.tma.mapper.TmaTotamoConfigMapper;
import com.github.akers.tma.service.ITmaTotamoConfigService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 番茄配置Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-01
 */
@RequiredArgsConstructor
@Service
public class TmaTotamoConfigServiceImpl implements ITmaTotamoConfigService {

    private final TmaTotamoConfigMapper baseMapper;

    /**
     * 查询番茄配置
     */
    @Override
    public TmaTotamoConfigVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询番茄配置列表
     */
    @Override
    public TableDataInfo<TmaTotamoConfigVo> queryPageList(TmaTotamoConfigBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<TmaTotamoConfig> lqw = buildQueryWrapper(bo);
        Page<TmaTotamoConfigVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询番茄配置列表
     */
    @Override
    public List<TmaTotamoConfigVo> queryList(TmaTotamoConfigBo bo) {
        LambdaQueryWrapper<TmaTotamoConfig> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TmaTotamoConfig> buildQueryWrapper(TmaTotamoConfigBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TmaTotamoConfig> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getConfigId()), TmaTotamoConfig::getConfigId, bo.getConfigId());
        lqw.eq(bo.getTimerFocus() != null, TmaTotamoConfig::getTimerFocus, bo.getTimerFocus());
        lqw.eq(bo.getTimerShortBreak() != null, TmaTotamoConfig::getTimerShortBreak, bo.getTimerShortBreak());
        lqw.eq(bo.getTimerLongBreak() != null, TmaTotamoConfig::getTimerLongBreak, bo.getTimerLongBreak());
        lqw.eq(bo.getTimerRounds() != null, TmaTotamoConfig::getTimerRounds, bo.getTimerRounds());
        lqw.eq(StringUtils.isNotBlank(bo.getUserId()), TmaTotamoConfig::getUserId, bo.getUserId());
        return lqw;
    }

    /**
     * 新增番茄配置
     */
    @Override
    public Boolean insertByBo(TmaTotamoConfigBo bo) {
        TmaTotamoConfig add = BeanUtil.toBean(bo, TmaTotamoConfig.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改番茄配置
     */
    @Override
    public Boolean updateByBo(TmaTotamoConfigBo bo) {
        TmaTotamoConfig update = BeanUtil.toBean(bo, TmaTotamoConfig.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(TmaTotamoConfig entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除番茄配置
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
