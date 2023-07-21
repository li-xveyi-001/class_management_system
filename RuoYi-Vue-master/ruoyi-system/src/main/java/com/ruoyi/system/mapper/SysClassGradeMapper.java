package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.SysClassGrade;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-07-18
 */
public interface SysClassGradeMapper
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
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysClassGradeById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysClassGradeByIds(Long[] ids);

    SysUser selectUserByUserNumber (@Param("userNumber") Long userNumber,@Param("semesterId") Long semesterId);
}
