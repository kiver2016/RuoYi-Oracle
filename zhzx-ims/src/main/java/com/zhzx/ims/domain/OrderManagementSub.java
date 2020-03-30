package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;

/**
 * 订单信息子对象 order_management_sub
 * 
 * @author kiver
 * @date 2019-12-04
 */
public class OrderManagementSub extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long orderManagementSubId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String materialName;

    /** 品牌 */
    @Excel(name = "品牌")
    private String materialBrand;

    /** 型号 */
    @Excel(name = "型号")
    private String materialModel;

    /** 规格 */
    @Excel(name = "规格")
    private String materialNorms;

    /** 产品大类 */
    @Excel(name = "产品大类")
    private String materialLargeClass;

    /** 产品小类 */
    @Excel(name = "产品小类")
    private String materialSubClass;

    /** 单位 */
    @Excel(name = "单位")
    private String materialUnit;

    /** 数量 */
    @Excel(name = "数量")
    private String materialNum;

    /** 单价 */
    @Excel(name = "单价")
    private String unitPrice;

    /** 总价 */
    @Excel(name = "总价")
    private String totalPrice;

    /** 已预付 */
    @Excel(name = "已预付")
    private String prepaid;

    /** 应付尾款 */
    @Excel(name = "应付尾款")
    private String payable;

    /** 父表ID */
    @Excel(name = "父表ID")
    private String parentId;

    public void setOrderManagementSubId(Long orderManagementSubId) 
    {
        this.orderManagementSubId = orderManagementSubId;
    }

    public Long getOrderManagementSubId() 
    {
        return orderManagementSubId;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMaterialBrand(String materialBrand) 
    {
        this.materialBrand = materialBrand;
    }

    public String getMaterialBrand() 
    {
        return materialBrand;
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
    public void setMaterialLargeClass(String materialLargeClass) 
    {
        this.materialLargeClass = materialLargeClass;
    }

    public String getMaterialLargeClass() 
    {
        return materialLargeClass;
    }
    public void setMaterialSubClass(String materialSubClass) 
    {
        this.materialSubClass = materialSubClass;
    }

    public String getMaterialSubClass() 
    {
        return materialSubClass;
    }
    public void setMaterialUnit(String materialUnit) 
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit() 
    {
        return materialUnit;
    }
    public void setMaterialNum(String materialNum) 
    {
        this.materialNum = materialNum;
    }

    public String getMaterialNum() 
    {
        return materialNum;
    }
    public void setUnitPrice(String unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public String getUnitPrice() 
    {
        return unitPrice;
    }
    public void setTotalPrice(String totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public String getTotalPrice() 
    {
        return totalPrice;
    }
    public void setPrepaid(String prepaid) 
    {
        this.prepaid = prepaid;
    }

    public String getPrepaid() 
    {
        return prepaid;
    }
    public void setPayable(String payable) 
    {
        this.payable = payable;
    }

    public String getPayable() 
    {
        return payable;
    }
    public void setParentId(String parentId) 
    {
        this.parentId = parentId;
    }

    public String getParentId() 
    {
        return parentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderManagementSubId", getOrderManagementSubId())
            .append("materialName", getMaterialName())
            .append("materialBrand", getMaterialBrand())
            .append("materialModel", getMaterialModel())
            .append("materialNorms", getMaterialNorms())
            .append("materialLargeClass", getMaterialLargeClass())
            .append("materialSubClass", getMaterialSubClass())
            .append("materialUnit", getMaterialUnit())
            .append("materialNum", getMaterialNum())
            .append("unitPrice", getUnitPrice())
            .append("totalPrice", getTotalPrice())
            .append("prepaid", getPrepaid())
            .append("payable", getPayable())
            .append("parentId", getParentId())
            .toString();
    }
}
