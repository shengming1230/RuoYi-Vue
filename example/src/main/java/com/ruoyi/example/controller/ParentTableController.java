package com.ruoyi.example.controller;

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
import com.ruoyi.example.domain.ParentTable;
import com.ruoyi.example.service.IParentTableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 父测试Controller
 * 
 * @author shengming
 * @date 2023-09-05
 */
@RestController
@RequestMapping("/example/table")
public class ParentTableController extends BaseController
{
    @Autowired
    private IParentTableService parentTableService;

    /**
     * 查询父测试列表
     */
    @PreAuthorize("@ss.hasPermi('example:table:list')")
    @GetMapping("/list")
    public TableDataInfo list(ParentTable parentTable)
    {
        startPage();
        List<ParentTable> list = parentTableService.selectParentTableList(parentTable);
        return getDataTable(list);
    }

    /**
     * 导出父测试列表
     */
    @PreAuthorize("@ss.hasPermi('example:table:export')")
    @Log(title = "父测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ParentTable parentTable)
    {
        List<ParentTable> list = parentTableService.selectParentTableList(parentTable);
        ExcelUtil<ParentTable> util = new ExcelUtil<ParentTable>(ParentTable.class);
        util.exportExcel(response, list, "父测试数据");
    }

    /**
     * 获取父测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('example:table:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(parentTableService.selectParentTableById(id));
    }

    /**
     * 新增父测试
     */
    @PreAuthorize("@ss.hasPermi('example:table:add')")
    @Log(title = "父测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ParentTable parentTable)
    {
        return toAjax(parentTableService.insertParentTable(parentTable));
    }

    /**
     * 修改父测试
     */
    @PreAuthorize("@ss.hasPermi('example:table:edit')")
    @Log(title = "父测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ParentTable parentTable)
    {
        return toAjax(parentTableService.updateParentTable(parentTable));
    }

    /**
     * 删除父测试
     */
    @PreAuthorize("@ss.hasPermi('example:table:remove')")
    @Log(title = "父测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(parentTableService.deleteParentTableByIds(ids));
    }
}
