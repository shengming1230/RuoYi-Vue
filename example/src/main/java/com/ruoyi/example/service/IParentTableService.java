package com.ruoyi.example.service;

import java.util.List;
import com.ruoyi.example.domain.ParentTable;

/**
 * 父测试Service接口
 * 
 * @author shengming
 * @date 2023-09-05
 */
public interface IParentTableService 
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
     * 批量删除父测试
     * 
     * @param ids 需要删除的父测试主键集合
     * @return 结果
     */
    public int deleteParentTableByIds(Long[] ids);

    /**
     * 删除父测试信息
     * 
     * @param id 父测试主键
     * @return 结果
     */
    public int deleteParentTableById(Long id);
}
