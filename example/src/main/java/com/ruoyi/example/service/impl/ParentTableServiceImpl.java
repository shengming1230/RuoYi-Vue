package com.ruoyi.example.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.example.domain.ChildTable;
import com.ruoyi.example.mapper.ParentTableMapper;
import com.ruoyi.example.domain.ParentTable;
import com.ruoyi.example.service.IParentTableService;

/**
 * 父测试Service业务层处理
 * 
 * @author shengming
 * @date 2023-09-05
 */
@Service
public class ParentTableServiceImpl implements IParentTableService 
{
    @Autowired
    private ParentTableMapper parentTableMapper;

    /**
     * 查询父测试
     * 
     * @param id 父测试主键
     * @return 父测试
     */
    @Override
    public ParentTable selectParentTableById(Long id)
    {
        return parentTableMapper.selectParentTableById(id);
    }

    /**
     * 查询父测试列表
     * 
     * @param parentTable 父测试
     * @return 父测试
     */
    @Override
    public List<ParentTable> selectParentTableList(ParentTable parentTable)
    {
        return parentTableMapper.selectParentTableList(parentTable);
    }

    /**
     * 新增父测试
     * 
     * @param parentTable 父测试
     * @return 结果
     */
    @Transactional
    @Override
    public int insertParentTable(ParentTable parentTable)
    {
        parentTable.setCreateTime(DateUtils.getNowDate());
        int rows = parentTableMapper.insertParentTable(parentTable);
        insertChildTable(parentTable);
        return rows;
    }

    /**
     * 修改父测试
     * 
     * @param parentTable 父测试
     * @return 结果
     */
    @Transactional
    @Override
    public int updateParentTable(ParentTable parentTable)
    {
        parentTable.setUpdateTime(DateUtils.getNowDate());
        parentTableMapper.deleteChildTableByParentId(parentTable.getId());
        insertChildTable(parentTable);
        return parentTableMapper.updateParentTable(parentTable);
    }

    /**
     * 批量删除父测试
     * 
     * @param ids 需要删除的父测试主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteParentTableByIds(Long[] ids)
    {
        parentTableMapper.deleteChildTableByParentIds(ids);
        return parentTableMapper.deleteParentTableByIds(ids);
    }

    /**
     * 删除父测试信息
     * 
     * @param id 父测试主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteParentTableById(Long id)
    {
        parentTableMapper.deleteChildTableByParentId(id);
        return parentTableMapper.deleteParentTableById(id);
    }

    /**
     * 新增子测试信息
     * 
     * @param parentTable 父测试对象
     */
    public void insertChildTable(ParentTable parentTable)
    {
        List<ChildTable> childTableList = parentTable.getChildTableList();
        Long id = parentTable.getId();
        if (StringUtils.isNotNull(childTableList))
        {
            List<ChildTable> list = new ArrayList<ChildTable>();
            for (ChildTable childTable : childTableList)
            {
                childTable.setParentId(id);
                list.add(childTable);
            }
            if (list.size() > 0)
            {
                parentTableMapper.batchChildTable(list);
            }
        }
    }
}
