package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysClassGrade;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-07-18
 */
public interface ISysClassGradeService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysClassGrade selectSysClassGradeById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sysClassGrade 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysClassGrade> selectSysClassGradeList(SysClassGrade sysClassGrade);

    /**
     * 新增【请填写功能名称】
     *
     * @param sysClassGrade 【请填写功能名称】
     * @return 结果
     */
    public int insertSysClassGrade(SysClassGrade sysClassGrade);

    /**
     * 修改【请填写功能名称】
     *
     * @param sysClassGrade 【请填写功能名称】
     * @return 结果
     */
    public int updateSysClassGrade(SysClassGrade sysClassGrade);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysClassGradeByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysClassGradeById(Long id);
}
