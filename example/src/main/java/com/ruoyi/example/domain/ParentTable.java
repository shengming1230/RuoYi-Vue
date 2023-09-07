package com.ruoyi.example.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 父测试对象 t_parent_table
 * 
 * @author shengming
 * @date 2023-09-05
 */
public class ParentTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 业务编码（自动生成唯一uuid） */
    @Excel(name = "业务编码", readConverterExp = "自=动生成唯一uuid")
    private String parentTableCode;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 办理期限 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "办理期限", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handleTime;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 基本情况 */
    @Excel(name = "基本情况")
    private String baseInfo;

    /** 状态 0:未删除  1:删除 */
    @Excel(name = "状态 0:未删除  1:删除")
    private Integer deleted;

    /** 子测试信息 */
    private List<ChildTable> childTableList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setParentTableCode(String parentTableCode) 
    {
        this.parentTableCode = parentTableCode;
    }

    public String getParentTableCode() 
    {
        return parentTableCode;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setHandleTime(Date handleTime) 
    {
        this.handleTime = handleTime;
    }

    public Date getHandleTime() 
    {
        return handleTime;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setBaseInfo(String baseInfo) 
    {
        this.baseInfo = baseInfo;
    }

    public String getBaseInfo() 
    {
        return baseInfo;
    }
    public void setDeleted(Integer deleted) 
    {
        this.deleted = deleted;
    }

    public Integer getDeleted() 
    {
        return deleted;
    }

    public List<ChildTable> getChildTableList()
    {
        return childTableList;
    }

    public void setChildTableList(List<ChildTable> childTableList)
    {
        this.childTableList = childTableList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentTableCode", getParentTableCode())
            .append("title", getTitle())
            .append("handleTime", getHandleTime())
            .append("content", getContent())
            .append("baseInfo", getBaseInfo())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("deleted", getDeleted())
            .append("childTableList", getChildTableList())
            .toString();
    }
}
