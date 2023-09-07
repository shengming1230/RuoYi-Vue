package com.ruoyi.example.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 指令基本信息对象 t_instruction_info
 *
 * @author shengming
 * @date 2023-09-05
 */
@ApiModel("指令基本信息对象")
public class InstructionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 指令主键 */
    @ApiModelProperty("指令主键")
    private Long id;

    /** 指令编码（自动生成唯一uuid） */
    @Excel(name = "指令编码", readConverterExp = "自=动生成唯一uuid")
    @ApiModelProperty("指令编码")
    private String instructionCode;

    /** 指令标题 */
    @Excel(name = "指令标题")
    @ApiModelProperty("指令标题")
    private String instructionTitle;

    /** 办理期限 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "办理期限", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("办理期限")
    private Date handleTime;

    /** 接收单位 */
    @Excel(name = "接收单位")
    @ApiModelProperty("接收单位")
    private String receiveUnit;

    /** 紧急程度 */
    @Excel(name = "紧急程度")
    @ApiModelProperty("紧急程度")
    private String emergencyDegree;

    /** 关联群体id */
    @Excel(name = "关联群体id")
    @ApiModelProperty("关联群体id")
    private Long groupId;

    /** 事件类型 */
    @Excel(name = "事件类型")
    @ApiModelProperty("事件类型")
    private String type;

    /** 信息来源 */
    @Excel(name = "信息来源")
    @ApiModelProperty("信息来源")
    private String sourceInfo;

    /** 指令内容 */
    @Excel(name = "指令内容")
    @ApiModelProperty("指令内容")
    private String instructionContent;

    /** 基本情况 */
    @Excel(name = "基本情况")
    @ApiModelProperty("基本情况")
    private String baseInfo;

    /** 创建者 */
    @Excel(name = "创建者")
    @ApiModelProperty("创建者")
    private String creatorBy;

    /** 状态 1:正常  9：删除 */
    @Excel(name = "状态 1:正常  9：删除")
    @ApiModelProperty("状态 1:正常  9：删除")
    private String status;

    /** 指令状态 1:交办 2:暂存 */
    @Excel(name = "指令状态 1:交办 2:暂存")
    @ApiModelProperty("指令状态 1:交办 2:暂存")
    private String instructionStatus;

    /** 反馈要求 */
    @Excel(name = "反馈要求")
    @ApiModelProperty("反馈要求")
    private String feedback;

    /** 人员ids */
    @Excel(name = "人员ids")
    @ApiModelProperty("人员ids")
    private String personIds;

    /** 指令创建者部门id */
    @Excel(name = "指令创建者部门id")
    @ApiModelProperty("指令创建者部门id")
    private Long createDeptId;

    /** 牵头人员id */
    @Excel(name = "牵头人员id")
    @ApiModelProperty("牵头人员id")
    private String leadPersonIds;

    /** 上访类型1：到市 2：赴省 3：进京 */
    @Excel(name = "上访类型1：到市 2：赴省 3：进京")
    @ApiModelProperty("上访类型1：到市 2：赴省 3：进京")
    private String petitionType;

    /** 推送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "推送时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("推送时间")
    private Date pushTime;

    /** 信息类别（从字典表中获取） */
    @Excel(name = "信息类别", readConverterExp = "从=字典表中获取")
    @ApiModelProperty("信息类别")
    private String infoCategory;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setInstructionCode(String instructionCode)
    {
        this.instructionCode = instructionCode;
    }

    public String getInstructionCode()
    {
        return instructionCode;
    }
    public void setInstructionTitle(String instructionTitle)
    {
        this.instructionTitle = instructionTitle;
    }

    public String getInstructionTitle()
    {
        return instructionTitle;
    }
    public void setHandleTime(Date handleTime)
    {
        this.handleTime = handleTime;
    }

    public Date getHandleTime()
    {
        return handleTime;
    }
    public void setReceiveUnit(String receiveUnit)
    {
        this.receiveUnit = receiveUnit;
    }

    public String getReceiveUnit()
    {
        return receiveUnit;
    }
    public void setEmergencyDegree(String emergencyDegree)
    {
        this.emergencyDegree = emergencyDegree;
    }

    public String getEmergencyDegree()
    {
        return emergencyDegree;
    }
    public void setGroupId(Long groupId)
    {
        this.groupId = groupId;
    }

    public Long getGroupId()
    {
        return groupId;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setSourceInfo(String sourceInfo)
    {
        this.sourceInfo = sourceInfo;
    }

    public String getSourceInfo()
    {
        return sourceInfo;
    }
    public void setInstructionContent(String instructionContent)
    {
        this.instructionContent = instructionContent;
    }

    public String getInstructionContent()
    {
        return instructionContent;
    }
    public void setBaseInfo(String baseInfo)
    {
        this.baseInfo = baseInfo;
    }

    public String getBaseInfo()
    {
        return baseInfo;
    }
    public void setCreatorBy(String creatorBy)
    {
        this.creatorBy = creatorBy;
    }

    public String getCreatorBy()
    {
        return creatorBy;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setInstructionStatus(String instructionStatus)
    {
        this.instructionStatus = instructionStatus;
    }

    public String getInstructionStatus()
    {
        return instructionStatus;
    }
    public void setFeedback(String feedback)
    {
        this.feedback = feedback;
    }

    public String getFeedback()
    {
        return feedback;
    }
    public void setPersonIds(String personIds)
    {
        this.personIds = personIds;
    }

    public String getPersonIds()
    {
        return personIds;
    }
    public void setCreateDeptId(Long createDeptId)
    {
        this.createDeptId = createDeptId;
    }

    public Long getCreateDeptId()
    {
        return createDeptId;
    }
    public void setLeadPersonIds(String leadPersonIds)
    {
        this.leadPersonIds = leadPersonIds;
    }

    public String getLeadPersonIds()
    {
        return leadPersonIds;
    }
    public void setPetitionType(String petitionType)
    {
        this.petitionType = petitionType;
    }

    public String getPetitionType()
    {
        return petitionType;
    }
    public void setPushTime(Date pushTime)
    {
        this.pushTime = pushTime;
    }

    public Date getPushTime()
    {
        return pushTime;
    }
    public void setInfoCategory(String infoCategory)
    {
        this.infoCategory = infoCategory;
    }

    public String getInfoCategory()
    {
        return infoCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("instructionCode", getInstructionCode())
            .append("instructionTitle", getInstructionTitle())
            .append("handleTime", getHandleTime())
            .append("receiveUnit", getReceiveUnit())
            .append("emergencyDegree", getEmergencyDegree())
            .append("groupId", getGroupId())
            .append("type", getType())
            .append("sourceInfo", getSourceInfo())
            .append("instructionContent", getInstructionContent())
            .append("baseInfo", getBaseInfo())
            .append("createTime", getCreateTime())
            .append("creatorBy", getCreatorBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("instructionStatus", getInstructionStatus())
            .append("feedback", getFeedback())
            .append("personIds", getPersonIds())
            .append("createDeptId", getCreateDeptId())
            .append("leadPersonIds", getLeadPersonIds())
            .append("petitionType", getPetitionType())
            .append("pushTime", getPushTime())
            .append("infoCategory", getInfoCategory())
            .toString();
    }
}
