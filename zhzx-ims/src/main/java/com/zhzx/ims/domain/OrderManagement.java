package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 订单信息对象 order_management
 * 
 * @author kiver
 * @date 2019-12-04
 */
public class OrderManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long orderManagementId;

    /** 下单日期 */
    @Excel(name = "下单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String customerAddress;

    /** 品牌 */
    @Excel(name = "品牌")
    private String materialBrand;

    /** 已预付 */
    @Excel(name = "已预付")
    private String prepaid;

    /** 应付尾款 */
    @Excel(name = "应付尾款")
    private String payable;

    /** 是否已结清 */
    @Excel(name = "是否已结清")
    private String sfyjq;

    /** 尾款支付日期 */
    @Excel(name = "尾款支付日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wkzfrq;

    /** 预提货日期 */
    @Excel(name = "预提货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ythrq;

    /** 负责人 */
    @Excel(name = "负责人")
    private String fzr;

    /** 实际送货日期 */
    @Excel(name = "实际送货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sjshrq;

    /** 送货人 */
    @Excel(name = "送货人")
    private String deliverer;

    public void setOrderManagementId(Long orderManagementId) 
    {
        this.orderManagementId = orderManagementId;
    }

    public Long getOrderManagementId() 
    {
        return orderManagementId;
    }
    public void setOrderDate(Date orderDate) 
    {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() 
    {
        return orderDate;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setCustomerAddress(String customerAddress) 
    {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddress() 
    {
        return customerAddress;
    }
    public void setMaterialBrand(String materialBrand) 
    {
        this.materialBrand = materialBrand;
    }

    public String getMaterialBrand() 
    {
        return materialBrand;
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
    public void setSfyjq(String sfyjq) 
    {
        this.sfyjq = sfyjq;
    }

    public String getSfyjq() 
    {
        return sfyjq;
    }
    public void setWkzfrq(Date wkzfrq) 
    {
        this.wkzfrq = wkzfrq;
    }

    public Date getWkzfrq() 
    {
        return wkzfrq;
    }
    public void setYthrq(Date ythrq) 
    {
        this.ythrq = ythrq;
    }

    public Date getYthrq() 
    {
        return ythrq;
    }
    public void setFzr(String fzr) 
    {
        this.fzr = fzr;
    }

    public String getFzr() 
    {
        return fzr;
    }
    public void setSjshrq(Date sjshrq) 
    {
        this.sjshrq = sjshrq;
    }

    public Date getSjshrq() 
    {
        return sjshrq;
    }

    public String getDeliverer() {
		return deliverer;
	}

	public void setDeliverer(String deliverer) {
		this.deliverer = deliverer;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderManagementId", getOrderManagementId())
            .append("orderDate", getOrderDate())
            .append("customerName", getCustomerName())
            .append("customerAddress", getCustomerAddress())
            .append("materialBrand", getMaterialBrand())
            .append("remark", getRemark())
            .append("prepaid", getPrepaid())
            .append("payable", getPayable())
            .append("sfyjq", getSfyjq())
            .append("wkzfrq", getWkzfrq())
            .append("ythrq", getYthrq())
            .append("fzr", getFzr())
            .append("sjshrq", getSjshrq())
            .append("shr", getDeliverer())
            .toString();
    }
}
