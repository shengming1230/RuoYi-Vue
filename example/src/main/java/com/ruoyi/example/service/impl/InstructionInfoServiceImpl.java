package com.ruoyi.example.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.example.mapper.InstructionInfoMapper;
import com.ruoyi.example.domain.InstructionInfo;
import com.ruoyi.example.service.IInstructionInfoService;

/**
 * 指令基本信息Service业务层处理
 * 
 * @author shengming
 * @date 2023-09-05
 */
@Service
public class InstructionInfoServiceImpl implements IInstructionInfoService 
{
    @Autowired
    private InstructionInfoMapper instructionInfoMapper;

    /**
     * 查询指令基本信息
     * 
     * @param id 指令基本信息主键
     * @return 指令基本信息
     */
    @Override
    public InstructionInfo selectInstructionInfoById(Long id)
    {
        return instructionInfoMapper.selectInstructionInfoById(id);
    }

    /**
     * 查询指令基本信息列表
     * 
     * @param instructionInfo 指令基本信息
     * @return 指令基本信息
     */
    @Override
    public List<InstructionInfo> selectInstructionInfoList(InstructionInfo instructionInfo)
    {
        return instructionInfoMapper.selectInstructionInfoList(instructionInfo);
    }

    /**
     * 新增指令基本信息
     * 
     * @param instructionInfo 指令基本信息
     * @return 结果
     */
    @Override
    public int insertInstructionInfo(InstructionInfo instructionInfo)
    {
        instructionInfo.setCreateTime(DateUtils.getNowDate());
        return instructionInfoMapper.insertInstructionInfo(instructionInfo);
    }

    /**
     * 修改指令基本信息
     * 
     * @param instructionInfo 指令基本信息
     * @return 结果
     */
    @Override
    public int updateInstructionInfo(InstructionInfo instructionInfo)
    {
        instructionInfo.setUpdateTime(DateUtils.getNowDate());
        return instructionInfoMapper.updateInstructionInfo(instructionInfo);
    }

    /**
     * 批量删除指令基本信息
     * 
     * @param ids 需要删除的指令基本信息主键
     * @return 结果
     */
    @Override
    public int deleteInstructionInfoByIds(Long[] ids)
    {
        return instructionInfoMapper.deleteInstructionInfoByIds(ids);
    }

    /**
     * 删除指令基本信息信息
     * 
     * @param id 指令基本信息主键
     * @return 结果
     */
    @Override
    public int deleteInstructionInfoById(Long id)
    {
        return instructionInfoMapper.deleteInstructionInfoById(id);
    }
}
