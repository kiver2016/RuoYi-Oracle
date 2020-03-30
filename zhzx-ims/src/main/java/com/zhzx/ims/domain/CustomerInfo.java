package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;

/**
 * 客户信息对象 customer_info
 * 
 * @author kiver
 * @date 2019-12-04
 */
public class CustomerInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long customerInfoId;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customerName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String customerPhone;

    /** 地址 */
    @Excel(name = "地址")
    private String customerAddress;

    /** 设计师 */
    @Excel(name = "设计师")
    private String designer;

    /** 装修公司 */
    @Excel(name = "装修公司")
    private String decorationCompany;

    /** 销售员 */
    @Excel(name = "销售员")
    private String salesperson;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStatus;

    /** 已付款 */
    @Excel(name = "已付款")
    private String orderPay;

    /** 是否结清 */
    @Excel(name = "是否结清")
    private String sfjq;

    public void setCustomerInfoId(Long customerInfoId) 
    {
        this.customerInfoId = customerInfoId;
    }

    public Long getCustomerInfoId() 
    {
        return customerInfoId;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setCustomerPhone(String customerPhone) 
    {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPhone() 
    {
        return customerPhone;
    }
    public void setCustomerAddress(String customerAddress) 
    {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddress() 
    {
        return customerAddress;
    }
    public void setDesigner(String designer) 
    {
        this.designer = designer;
    }

    public String getDesigner() 
    {
        return designer;
    }
    public void setDecorationCompany(String decorationCompany) 
    {
        this.decorationCompany = decorationCompany;
    }

    public String getDecorationCompany() 
    {
        return decorationCompany;
    }
    public void setSalesperson(String salesperson) 
    {
        this.salesperson = salesperson;
    }

    public String getSalesperson() 
    {
        return salesperson;
    }
    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }
    public void setOrderPay(String orderPay) 
    {
        this.orderPay = orderPay;
    }

    public String getOrderPay() 
    {
        return orderPay;
    }
    public void setSfjq(String sfjq) 
    {
        this.sfjq = sfjq;
    }

    public String getSfjq() 
    {
        return sfjq;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerInfoId", getCustomerInfoId())
            .append("customerName", getCustomerName())
            .append("customerPhone", getCustomerPhone())
            .append("customerAddress", getCustomerAddress())
            .append("designer", getDesigner())
            .append("decorationCompany", getDecorationCompany())
            .append("salesperson", getSalesperson())
            .append("orderStatus", getOrderStatus())
            .append("orderPay", getOrderPay())
            .append("sfjq", getSfjq())
            .toString();
    }
}
