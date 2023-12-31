package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysClassGrade;
import com.ruoyi.system.service.ISysClassGradeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-07-18
 */
@RestController
@RequestMapping("/system/grade")
public class SysClassGradeController extends BaseController
{
    @Autowired
    private ISysClassGradeService sysClassGradeService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysClassGrade sysClassGrade)
    {
        System.out.println("列表");
        startPage();
        List<SysClassGrade> list = sysClassGradeService.selectSysClassGradeList(sysClassGrade);
        return getDataTable(list);
    }

    /**
    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:grade:export')")
    @Log(title = "成绩管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysClassGrade sysClassGrade)
    {
        List<SysClassGrade> list = sysClassGradeService.selectSysClassGradeList(sysClassGrade);
        ExcelUtil<SysClassGrade> util = new ExcelUtil<SysClassGrade>(SysClassGrade.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:grade:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysClassGradeService.selectSysClassGradeById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:grade:add')")
    @Log(title = "成绩管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysClassGrade sysClassGrade)
    {
        return toAjax(sysClassGradeService.insertSysClassGrade(sysClassGrade));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:grade:edit')")
    @Log(title = "成绩管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysClassGrade sysClassGrade)
    {
        return toAjax(sysClassGradeService.updateSysClassGrade(sysClassGrade));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:grade:remove')")
    @Log(title = "成绩管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysClassGradeService.deleteSysClassGradeByIds(ids));
    }
}
