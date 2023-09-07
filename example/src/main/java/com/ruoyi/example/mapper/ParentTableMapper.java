package com.ruoyi.example.mapper;

import java.util.List;
import com.ruoyi.example.domain.ParentTable;
import com.ruoyi.example.domain.ChildTable;

/**
 * 父测试Mapper接口
 * 
 * @author shengming
 * @date 2023-09-05
 */
public interface ParentTableMapper 
{
    /**
     * 查询父测试
     * 
     * @param id 父测试主键
     * @return 父测试
     */
    public ParentTable selectParentTableById(Long id);

    /**
     * 查询父测试列表
     * 
     * @param parentTable 父测试
     * @return 父测试集合
     */
    public List<ParentTable> selectParentTableList(ParentTable parentTable);

    /**
     * 新增父测试
     * 
     * @param parentTable 父测试
     * @return 结果
     */
    public int insertParentTable(ParentTable parentTable);

    /**
     * 修改父测试
     * 
     * @param parentTable 父测试
     * @return 结果
     */
    public int updateParentTable(ParentTable parentTable);

    /**
     * 删除父测试
     * 
     * @param id 父测试主键
     * @return 结果
     */
    public int deleteParentTableById(Long id);

    /**
     * 批量删除父测试
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteParentTableByIds(Long[] ids);

    /**
     * 批量删除子测试
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChildTableByParentIds(Long[] ids);
    
    /**
     * 批量新增子测试
     * 
     * @param childTableList 子测试列表
     * @return 结果
     */
    public int batchChildTable(List<ChildTable> childTableList);
    

    /**
     * 通过父测试主键删除子测试信息
     * 
     * @param id 父测试ID
     * @return 结果
     */
    public int deleteChildTableByParentId(Long id);
}
