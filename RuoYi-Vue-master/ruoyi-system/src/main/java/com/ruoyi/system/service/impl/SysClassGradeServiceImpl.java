package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
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
    /**
     * 导入用户数据
     *
     * @param gradeList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importGrade(List<SysClassGrade> gradeList, Boolean isUpdateSupport, String operName)
    {
        System.out.println(gradeList);
        if (StringUtils.isNull(gradeList) || gradeList.size() == 0)
        {
            throw new ServiceException("导入成绩数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (SysClassGrade sysClassGrade : gradeList)
        {
            try
            {
                // 验证是否存在这个成绩记录
                long userNumber=sysClassGrade.getUserNumber();
                Long semesterId=sysClassGrade.getSemesterId();

                SysUser u = sysClassGradeMapper.selectUserByUserNumber(userNumber,semesterId);
                System.out.println(u);
                if (StringUtils.isNull(u))
                {

                    sysClassGradeMapper.insertSysClassGrade(sysClassGrade);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysClassGrade.getUserName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {

                    sysClassGradeMapper.updateSysClassGrade(sysClassGrade);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysClassGrade.getUserName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + sysClassGrade.getUserName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + sysClassGrade.getUserName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());

            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
