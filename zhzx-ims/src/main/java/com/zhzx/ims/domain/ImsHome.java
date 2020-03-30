package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;

/**
 * 主页展示对象 ims_home
 * 
 * @author kiver
 * @date 2020-02-21
 */
public class ImsHome extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long imsHomeId;

    /** 标题 */
    @Excel(name = "标题")
    private String imsHomeTitle;

    /** 内容 */
    @Excel(name = "内容")
    private String imsHomeContext;

    /** 类型 */
    @Excel(name = "类型")
    private String imsHomeType;
    
    private String uploadFile;
    
    private String filename;

    public void setImsHomeId(Long imsHomeId) 
    {
        this.imsHomeId = imsHomeId;
    }

    public Long getImsHomeId() 
    {
        return imsHomeId;
    }
    public void setImsHomeTitle(String imsHomeTitle) 
    {
        this.imsHomeTitle = imsHomeTitle;
    }

    public String getImsHomeTitle() 
    {
        return imsHomeTitle;
    }
    public void setImsHomeContext(String imsHomeContext) 
    {
        this.imsHomeContext = imsHomeContext;
    }

    public String getImsHomeContext() 
    {
        return imsHomeContext;
    }
    public void setImsHomeType(String imsHomeType) 
    {
        this.imsHomeType = imsHomeType;
    }

    public String getImsHomeType() 
    {
        return imsHomeType;
    }

    public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("imsHomeId", getImsHomeId())
            .append("imsHomeTitle", getImsHomeTitle())
            .append("imsHomeContext", getImsHomeContext())
            .append("imsHomeType", getImsHomeType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("uploadFile",getUploadFile())
            .append("filename",getFilename())
            .toString();
    }
}
