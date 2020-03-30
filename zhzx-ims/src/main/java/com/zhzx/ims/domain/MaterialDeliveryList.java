package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 送货清单对象 material_delivery_list
 * 
 * @author kiver
 * @date 2019-11-27
 */
public class MaterialDeliveryList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long deliveryListId;

    /** 顾客姓名 */
    @Excel(name = "顾客姓名")
    private String customer;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phonenum;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 日期 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryDate;

    /** 品牌 */
    @Excel(name = "品牌")
    private String materialBrand;

    /** 库房 */
    @Excel(name = "库房")
    private String storage;

    /** 经办人 */
    @Excel(name = "经办人")
    private String trustees;

    /** 日期 */
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date trusteesDate;

    /** 出库日期 */
    @Excel(name = "出库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date storageOutDate;

    /** 库管员 */
    @Excel(name = "库管员")
    private String storageManger;

    @Excel(name = "是否已出库")
    private String isOut;
    
    public void setDeliveryListId(Long deliveryListId) 
    {
        this.deliveryListId = deliveryListId;
    }

    public Long getDeliveryListId() 
    {
        return deliveryListId;
    }
    public void setCustomer(String customer) 
    {
        this.customer = customer;
    }

    public String getCustomer() 
    {
        return customer;
    }
    public void setPhonenum(String phonenum) 
    {
        this.phonenum = phonenum;
    }

    public String getPhonenum() 
    {
        return phonenum;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setDeliveryDate(Date deliveryDate) 
    {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() 
    {
        return deliveryDate;
    }
    public void setMaterialBrand(String materialBrand) 
    {
        this.materialBrand = materialBrand;
    }

    public String getMaterialBrand() 
    {
        return materialBrand;
    }
    public void setStorage(String storage) 
    {
        this.storage = storage;
    }

    public String getStorage() 
    {
        return storage;
    }
    public void setTrustees(String trustees) 
    {
        this.trustees = trustees;
    }

    public String getTrustees() 
    {
        return trustees;
    }
    public void setTrusteesDate(Date trusteesDate) 
    {
        this.trusteesDate = trusteesDate;
    }

    public Date getTrusteesDate() 
    {
        return trusteesDate;
    }
    public void setStorageOutDate(Date storageOutDate) 
    {
        this.storageOutDate = storageOutDate;
    }

    public Date getStorageOutDate() 
    {
        return storageOutDate;
    }
    public void setStorageManger(String storageManger) 
    {
        this.storageManger = storageManger;
    }

    public String getStorageManger() 
    {
        return storageManger;
    }

    public String getIsOut() {
		return isOut;
	}

	public void setIsOut(String isOut) {
		this.isOut = isOut;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deliveryListId", getDeliveryListId())
            .append("customer", getCustomer())
            .append("phonenum", getPhonenum())
            .append("address", getAddress())
            .append("deliveryDate", getDeliveryDate())
            .append("materialBrand", getMaterialBrand())
            .append("storage", getStorage())
            .append("trustees", getTrustees())
            .append("trusteesDate", getTrusteesDate())
            .append("storageOutDate", getStorageOutDate())
            .append("storageManger", getStorageManger())
            .append("isOut",getIsOut())
            .toString();
    }
}
