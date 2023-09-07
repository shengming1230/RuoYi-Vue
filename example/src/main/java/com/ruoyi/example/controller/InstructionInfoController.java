package com.ruoyi.example.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.example.domain.InstructionInfo;
import com.ruoyi.example.service.IInstructionInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 指令基本信息Controller
 *
 * @author shengming
 * @date 2023-09-05
 */
@RestController
@RequestMapping("/example/info")
@ApiModel("指令基本信息Controller")
public class InstructionInfoController extends BaseController
{
    @Autowired
    private IInstructionInfoService instructionInfoService;

    /**
     * 查询指令基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('example:info:list')")
    @GetMapping("/list")
    @ApiOperation("指令基本信息分页")
    public TableDataInfo list(InstructionInfo instructionInfo)
    {
        startPage();
        List<InstructionInfo> list = instructionInfoService.selectInstructionInfoList(instructionInfo);
        return getDataTable(list);
    }

    /**
     * 导出指令基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('example:info:export')")
    @Log(title = "指令基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("指令基本信息导出")
    public void export(HttpServletResponse response, InstructionInfo instructionInfo)
    {
        List<InstructionInfo> list = instructionInfoService.selectInstructionInfoList(instructionInfo);
        ExcelUtil<InstructionInfo> util = new ExcelUtil<InstructionInfo>(InstructionInfo.class);
        util.exportExcel(response, list, "指令基本信息数据");
    }

    /**
     * 获取指令基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('example:info:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("获取指令基本信息详细信息")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(instructionInfoService.selectInstructionInfoById(id));
    }

    /**
     * 新增指令基本信息
     */
    @PreAuthorize("@ss.hasPermi('example:info:add')")
    @Log(title = "指令基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增指令基本信息")
    public AjaxResult add(@RequestBody InstructionInfo instructionInfo)
    {
        return toAjax(instructionInfoService.insertInstructionInfo(instructionInfo));
    }

    /**
     * 修改指令基本信息
     */
    @PreAuthorize("@ss.hasPermi('example:info:edit')")
    @Log(title = "指令基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改指令基本信息")
    public AjaxResult edit(@RequestBody InstructionInfo instructionInfo)
    {
        return toAjax(instructionInfoService.updateInstructionInfo(instructionInfo));
    }

    /**
     * 删除指令基本信息
     */
    @PreAuthorize("@ss.hasPermi('example:info:remove')")
    @Log(title = "指令基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ApiOperation("删除指令基本信息")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(instructionInfoService.deleteInstructionInfoByIds(ids));
    }
}
