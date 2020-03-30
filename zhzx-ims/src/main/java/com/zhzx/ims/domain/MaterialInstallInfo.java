package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 安装信息对象 material_install_info
 * 
 * @author kiver
 * @date 2019-11-27
 */
public class MaterialInstallInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long materialInstallInfoId;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customer;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 安装人员 */
    @Excel(name = "安装人员")
    private String installPerson;

    /** 安装产品 */
    @Excel(name = "安装产品")
    private String installMaterial;

    /** 型号 */
    @Excel(name = "型号")
    private String materialModel;

    /** 规格 */
    @Excel(name = "规格")
    private String materialNorms;

    /** 面积 */
    @Excel(name = "面积")
    private String materialArea;

    /** 安装方式 */
    @Excel(name = "安装方式")
    private String installWay;

    /** 安装日期 */
    @Excel(name = "安装日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date installDate;

    /** 安装费用 */
    @Excel(name = "安装费用")
    private String installCost;

    /** 经办人 */
    @Excel(name = "经办人")
    private String operoter;

    public void setMaterialInstallInfoId(Long materialInstallInfoId) 
    {
        this.materialInstallInfoId = materialInstallInfoId;
    }

    public Long getMaterialInstallInfoId() 
    {
        return materialInstallInfoId;
    }
    public void setCustomer(String customer) 
    {
        this.customer = customer;
    }

    public String getCustomer() 
    {
        return customer;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setInstallPerson(String installPerson) 
    {
        this.installPerson = installPerson;
    }

    public String getInstallPerson() 
    {
        return installPerson;
    }
    public void setInstallMaterial(String installMaterial) 
    {
        this.installMaterial = installMaterial;
    }

    public String getInstallMaterial() 
    {
        return installMaterial;
    }
    public void setMaterialModel(String materialModel) 
    {
        this.materialModel = materialModel;
    }

    public String getMaterialModel() 
    {
        return materialModel;
    }
    public void setMaterialNorms(String materialNorms) 
    {
        this.materialNorms = materialNorms;
    }

    public String getMaterialNorms() 
    {
        return materialNorms;
    }
    public void setMaterialArea(String materialArea) 
    {
        this.materialArea = materialArea;
    }

    public String getMaterialArea() 
    {
        return materialArea;
    }
    public void setInstallWay(String installWay) 
    {
        this.installWay = installWay;
    }

    public String getInstallWay() 
    {
        return installWay;
    }
    public void setInstallDate(Date installDate) 
    {
        this.installDate = installDate;
    }

    public Date getInstallDate() 
    {
        return installDate;
    }
    public void setInstallCost(String installCost) 
    {
        this.installCost = installCost;
    }

    public String getInstallCost() 
    {
        return installCost;
    }
    public void setOperoter(String operoter) 
    {
        this.operoter = operoter;
    }

    public String getOperoter() 
    {
        return operoter;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialInstallInfoId", getMaterialInstallInfoId())
            .append("customer", getCustomer())
            .append("address", getAddress())
            .append("installPerson", getInstallPerson())
            .append("installMaterial", getInstallMaterial())
            .append("materialModel", getMaterialModel())
            .append("materialNorms", getMaterialNorms())
            .append("materialArea", getMaterialArea())
            .append("installWay", getInstallWay())
            .append("installDate", getInstallDate())
            .append("installCost", getInstallCost())
            .append("operoter", getOperoter())
            .toString();
    }
}
