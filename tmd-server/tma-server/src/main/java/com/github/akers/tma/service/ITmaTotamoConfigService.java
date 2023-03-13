package com.github.akers.tma.service;

import com.github.akers.tma.domain.TmaTotamoConfig;
import com.github.akers.tma.domain.vo.TmaTotamoConfigVo;
import com.github.akers.tma.domain.bo.TmaTotamoConfigBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 番茄配置Service接口
 *
 * @author ruoyi
 * @date 2023-03-01
 */
public interface ITmaTotamoConfigService {

    /**
     * 查询番茄配置
     */
    TmaTotamoConfigVo queryById(Long id);

    /**
     * 查询番茄配置列表
     */
    TableDataInfo<TmaTotamoConfigVo> queryPageList(TmaTotamoConfigBo bo, PageQuery pageQuery);

    /**
     * 查询番茄配置列表
     */
    List<TmaTotamoConfigVo> queryList(TmaTotamoConfigBo bo);

    /**
     * 新增番茄配置
     */
    Boolean insertByBo(TmaTotamoConfigBo bo);

    /**
     * 修改番茄配置
     */
    Boolean updateByBo(TmaTotamoConfigBo bo);

    /**
     * 校验并批量删除番茄配置信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
