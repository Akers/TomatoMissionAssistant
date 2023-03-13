package com.github.akers.tma.service;

import com.github.akers.tma.domain.TmaTeam;
import com.github.akers.tma.domain.vo.TmaTeamVo;
import com.github.akers.tma.domain.bo.TmaTeamBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 团队Service接口
 *
 * @author ruoyi
 * @date 2023-03-01
 */
public interface ITmaTeamService {

    /**
     * 查询团队
     */
    TmaTeamVo queryById(Long id);

    /**
     * 查询团队列表
     */
    TableDataInfo<TmaTeamVo> queryPageList(TmaTeamBo bo, PageQuery pageQuery);

    /**
     * 查询团队列表
     */
    List<TmaTeamVo> queryList(TmaTeamBo bo);

    /**
     * 新增团队
     */
    Boolean insertByBo(TmaTeamBo bo);

    /**
     * 修改团队
     */
    Boolean updateByBo(TmaTeamBo bo);

    /**
     * 校验并批量删除团队信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
