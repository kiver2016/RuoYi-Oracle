package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 材料入库信息子对象 material_put_storage_sub
 * 
 * @author kiver
 * @date 2019-11-27
 */
public class MaterialPutStorageSub extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long materialPutSubId;

    /** 入库时间 */
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date materialPutDate;

    /** 订单号 */
    @Excel(name = "订单号")
    private String materialOrder;

    /** 客户 */
    @Excel(name = "客户")
    private String customer;

    /** 品牌 */
    @Excel(name = "品牌")
    private String materialBrand;

    /** 运输费用 */
    @Excel(name = "运输费用")
    private String tCost;

    /** 运输人 */
    @Excel(name = "运输人")
    private String tPerson;

    /** 库房 */
    @Excel(name = "库房")
    private String storage;

    /** 库管员 */
    @Excel(name = "库管员")
    private String storageManger;

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

    /** 入库数量 */
    @Excel(name = "入库数量")
    private String putNum;

    /** 存放位置 */
    @Excel(name = "存放位置")
    private String storageLocation;
    
    private String parentId;
    
    public void setMaterialPutSubId(Long materialPutSubId) 
    {
        this.materialPutSubId = materialPutSubId;
    }

    public Long getMaterialPutSubId() 
    {
        return materialPutSubId;
    }
    public void setMaterialPutDate(Date materialPutDate) 
    {
        this.materialPutDate = materialPutDate;
    }

    public Date getMaterialPutDate() 
    {
        return materialPutDate;
    }
    public void setMaterialOrder(String materialOrder) 
    {
        this.materialOrder = materialOrder;
    }

    public String getMaterialOrder() 
    {
        return materialOrder;
    }
    public void setCustomer(String customer) 
    {
        this.customer = customer;
    }

    public String getCustomer() 
    {
        return customer;
    }
    public void setMaterialBrand(String materialBrand) 
    {
        this.materialBrand = materialBrand;
    }

    public String getMaterialBrand() 
    {
        return materialBrand;
    }
    public void settCost(String tCost) 
    {
        this.tCost = tCost;
    }

    public String gettCost() 
    {
        return tCost;
    }
    public void settPerson(String tPerson) 
    {
        this.tPerson = tPerson;
    }

    public String gettPerson() 
    {
        return tPerson;
    }
    public void setStorage(String storage) 
    {
        this.storage = storage;
    }

    public String getStorage() 
    {
        return storage;
    }
    public void setStorageManger(String storageManger) 
    {
        this.storageManger = storageManger;
    }

    public String getStorageManger() 
    {
        return storageManger;
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
    public void setPutNum(String putNum) 
    {
        this.putNum = putNum;
    }

    public String getPutNum() 
    {
        return putNum;
    }
    public void setStorageLocation(String storageLocation) 
    {
        this.storageLocation = storageLocation;
    }

    public String getStorageLocation() 
    {
        return storageLocation;
    }

    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialPutSubId", getMaterialPutSubId())
            .append("materialPutDate", getMaterialPutDate())
            .append("materialOrder", getMaterialOrder())
            .append("customer", getCustomer())
            .append("materialBrand", getMaterialBrand())
            .append("tCost", gettCost())
            .append("tPerson", gettPerson())
            .append("storage", getStorage())
            .append("storageManger", getStorageManger())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialNorms", getMaterialNorms())
            .append("materialLargeClass", getMaterialLargeClass())
            .append("materialSubClass", getMaterialSubClass())
            .append("putNum", getPutNum())
            .append("storageLocation", getStorageLocation())
            .append("remark", getRemark())
            .append("parentId",getParentId())
            .toString();
    }
}
