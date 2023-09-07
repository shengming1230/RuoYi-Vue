package com.ruoyi.example.service;

import java.util.List;
import com.ruoyi.example.domain.InstructionInfo;

/**
 * 指令基本信息Service接口
 * 
 * @author shengming
 * @date 2023-09-05
 */
public interface IInstructionInfoService 
{
    /**
     * 查询指令基本信息
     * 
     * @param id 指令基本信息主键
     * @return 指令基本信息
     */
    public InstructionInfo selectInstructionInfoById(Long id);

    /**
     * 查询指令基本信息列表
     * 
     * @param instructionInfo 指令基本信息
     * @return 指令基本信息集合
     */
    public List<InstructionInfo> selectInstructionInfoList(InstructionInfo instructionInfo);

    /**
     * 新增指令基本信息
     * 
     * @param instructionInfo 指令基本信息
     * @return 结果
     */
    public int insertInstructionInfo(InstructionInfo instructionInfo);

    /**
     * 修改指令基本信息
     * 
     * @param instructionInfo 指令基本信息
     * @return 结果
     */
    public int updateInstructionInfo(InstructionInfo instructionInfo);

    /**
     * 批量删除指令基本信息
     * 
     * @param ids 需要删除的指令基本信息主键集合
     * @return 结果
     */
    public int deleteInstructionInfoByIds(Long[] ids);

    /**
     * 删除指令基本信息信息
     * 
     * @param id 指令基本信息主键
     * @return 结果
     */
    public int deleteInstructionInfoById(Long id);
}
