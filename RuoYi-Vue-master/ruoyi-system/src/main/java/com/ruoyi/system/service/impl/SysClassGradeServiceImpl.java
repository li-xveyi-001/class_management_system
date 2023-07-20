package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysClassGradeMapper;
import com.ruoyi.system.domain.SysClassGrade;
import com.ruoyi.system.service.ISysClassGradeService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-18
 */
@Service
public class SysClassGradeServiceImpl implements ISysClassGradeService
{
    @Autowired
    private SysClassGradeMapper sysClassGradeMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysClassGrade selectSysClassGradeById(Long id)
    {
        return sysClassGradeMapper.selectSysClassGradeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysClassGrade 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysClassGrade> selectSysClassGradeList(SysClassGrade sysClassGrade)
    {
        return sysClassGradeMapper.selectSysClassGradeList(sysClassGrade);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param sysClassGrade 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysClassGrade(SysClassGrade sysClassGrade)
    {
        return sysClassGradeMapper.insertSysClassGrade(sysClassGrade);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sysClassGrade 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysClassGrade(SysClassGrade sysClassGrade)
    {
        return sysClassGradeMapper.updateSysClassGrade(sysClassGrade);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysClassGradeByIds(Long[] ids)
    {
        return sysClassGradeMapper.deleteSysClassGradeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysClassGradeById(Long id)
    {
        return sysClassGradeMapper.deleteSysClassGradeById(id);
    }
}
