package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 材料出库信息对象 material_out_storage
 * 
 * @author kiver
 * @date 2019-11-27
 */
public class MaterialOutStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long materialOutId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String materialName;

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

    /** 库房 */
    @Excel(name = "库房")
    private String storage;

    /** 出库数量 */
    @Excel(name = "出库数量")
    private String outNum;

    /** 出库时间 */
    @Excel(name = "出库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date materialOutDate;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customer;

    /** 送货地点 */
    @Excel(name = "送货地点")
    private String deliveryPlace;

    /** 运输费用 */
    @Excel(name = "运输费用")
    private String tCost;

    /** 经办人 */
    @Excel(name = "经办人")
    private String operoter;

    public void setMaterialOutId(Long materialOutId) 
    {
        this.materialOutId = materialOutId;
    }

    public Long getMaterialOutId() 
    {
        return materialOutId;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
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
    public void setStorage(String storage) 
    {
        this.storage = storage;
    }

    public String getStorage() 
    {
        return storage;
    }
    public void setOutNum(String outNum) 
    {
        this.outNum = outNum;
    }

    public String getOutNum() 
    {
        return outNum;
    }
    public void setMaterialOutDate(Date materialOutDate) 
    {
        this.materialOutDate = materialOutDate;
    }

    public Date getMaterialOutDate() 
    {
        return materialOutDate;
    }
    public void setCustomer(String customer) 
    {
        this.customer = customer;
    }

    public String getCustomer() 
    {
        return customer;
    }
    public void setDeliveryPlace(String deliveryPlace) 
    {
        this.deliveryPlace = deliveryPlace;
    }

    public String getDeliveryPlace() 
    {
        return deliveryPlace;
    }
    public void settCost(String tCost) 
    {
        this.tCost = tCost;
    }

    public String gettCost() 
    {
        return tCost;
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
            .append("materialOutId", getMaterialOutId())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialNorms", getMaterialNorms())
            .append("materialLargeClass", getMaterialLargeClass())
            .append("materialSubClass", getMaterialSubClass())
            .append("storage", getStorage())
            .append("outNum", getOutNum())
            .append("materialOutDate", getMaterialOutDate())
            .append("customer", getCustomer())
            .append("deliveryPlace", getDeliveryPlace())
            .append("tCost", gettCost())
            .append("operoter", getOperoter())
            .toString();
    }
}
