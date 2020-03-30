package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 材料入库信息对象 material_put_storage
 * 
 * @author kiver
 * @date 2019-11-27
 */
public class MaterialPutStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long materialPutId;

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
    
    private String confirmPutIn;

    public void setMaterialPutId(Long materialPutId) 
    {
        this.materialPutId = materialPutId;
    }

    public Long getMaterialPutId() 
    {
        return materialPutId;
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

    public String getConfirmPutIn() {
		return confirmPutIn;
	}

	public void setConfirmPutIn(String confirmPutIn) {
		this.confirmPutIn = confirmPutIn;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialPutId", getMaterialPutId())
            .append("materialPutDate", getMaterialPutDate())
            .append("materialOrder", getMaterialOrder())
            .append("customer", getCustomer())
            .append("materialBrand", getMaterialBrand())
            .append("tCost", gettCost())
            .append("tPerson", gettPerson())
            .append("storage", getStorage())
            .append("storageManger", getStorageManger())
            .append("confirmPutIn", getConfirmPutIn())
            .toString();
    }
}
