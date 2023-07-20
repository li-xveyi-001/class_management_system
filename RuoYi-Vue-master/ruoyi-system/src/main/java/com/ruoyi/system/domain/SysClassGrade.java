package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_class_grade
 *
 * @author ruoyi
 * @date 2023-07-18
 */
public class SysClassGrade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 学生学号 */
    @Excel(name = "学生学号")
    private Long userNumber;
    /** 部门ID */
    @Excel(name = "班级编号", type = Excel.Type.IMPORT)
    private Long deptId;

    /** 部门名字 */
    @Excel(name = "班级名字", type = Excel.Type.IMPORT)
    private String deptName;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String userName;

    /** 综合排名 */
    @Excel(name = "综合排名")
    private String overallRank;

    /** 综合分数 */
    @Excel(name = "综合分数")
    private String overallScore;

    /** 学习排名 */
    @Excel(name = "学习排名")
    private String learnRank;

    /** 学习分数 */
    @Excel(name = "学习分数")
    private String learnScore;

    /** 量化排名 */
    @Excel(name = "量化排名")
    private String quantificationRank;

    /** 量化分数 */
    @Excel(name = "量化分数")
    private String quantificationScore;




    /** 学期ID */
    @Excel(name = "学期ID")
    private String semesterId;
    /** 学期名称 */
    @Excel(name = "学期ID")
    private String semesterName;


    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserNumber(Long userNumber)
    {
        this.userNumber = userNumber;
    }

    public Long getUserNumber()
    {
        return userNumber;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setOverallRank(String overallRank)
    {
        this.overallRank = overallRank;
    }

    public String getOverallRank()
    {
        return overallRank;
    }
    public void setOverallScore(String overallScore)
    {
        this.overallScore = overallScore;
    }

    public String getOverallScore()
    {
        return overallScore;
    }
    public void setLearnRank(String learnRank)
    {
        this.learnRank = learnRank;
    }

    public String getLearnRank()
    {
        return learnRank;
    }
    public void setLearnScore(String learnScore)
    {
        this.learnScore = learnScore;
    }

    public String getLearnScore()
    {
        return learnScore;
    }
    public void setQuantificationRank(String quantificationRank)
    {
        this.quantificationRank = quantificationRank;
    }

    public String getQuantificationRank()
    {
        return quantificationRank;
    }
    public void setQuantificationScore(String quantificationScore)
    {
        this.quantificationScore = quantificationScore;
    }

    public String getQuantificationScore()
    {
        return quantificationScore;
    }

    public void setSemesterId(String semesterId)
    {
        this.semesterId = semesterId;
    }

    public String getSemesterId()
    {
        return semesterId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "SysClassGrade{" +
                "id=" + id +
                ", userNumber=" + userNumber +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", userName='" + userName + '\'' +
                ", overallRank='" + overallRank + '\'' +
                ", overallScore='" + overallScore + '\'' +
                ", learnRank='" + learnRank + '\'' +
                ", learnScore='" + learnScore + '\'' +
                ", quantificationRank='" + quantificationRank + '\'' +
                ", quantificationScore='" + quantificationScore + '\'' +
                ", semesterId='" + semesterId + '\'' +
                ", semesterName='" + semesterName + '\'' +
                '}';
    }
}
