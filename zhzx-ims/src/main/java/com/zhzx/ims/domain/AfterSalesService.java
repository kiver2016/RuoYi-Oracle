package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 售后服务记录对象 after_sales_service
 * 
 * @author kiver
 * @date 2019-11-27
 */
public class AfterSalesService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long afterSalesServiceId;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customer;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 售后服务内容 */
    @Excel(name = "售后服务内容")
    private String serviceContext;

    /** 现场照片 */
    @Excel(name = "现场照片")
    private String scenePhotos;

    /** 负责人 */
    @Excel(name = "负责人")
    private String hand;

    /** 售后服务日期 */
    @Excel(name = "售后服务日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date serviceDate;

    public void setAfterSalesServiceId(Long afterSalesServiceId) 
    {
        this.afterSalesServiceId = afterSalesServiceId;
    }

    public Long getAfterSalesServiceId() 
    {
        return afterSalesServiceId;
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
    public void setServiceContext(String serviceContext) 
    {
        this.serviceContext = serviceContext;
    }

    public String getServiceContext() 
    {
        return serviceContext;
    }
    public void setScenePhotos(String scenePhotos) 
    {
        this.scenePhotos = scenePhotos;
    }

    public String getScenePhotos() 
    {
        return scenePhotos;
    }
    public void setHand(String hand) 
    {
        this.hand = hand;
    }

    public String getHand() 
    {
        return hand;
    }
    public void setServiceDate(Date serviceDate) 
    {
        this.serviceDate = serviceDate;
    }

    public Date getServiceDate() 
    {
        return serviceDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("afterSalesServiceId", getAfterSalesServiceId())
            .append("customer", getCustomer())
            .append("address", getAddress())
            .append("serviceContext", getServiceContext())
            .append("scenePhotos", getScenePhotos())
            .append("hand", getHand())
            .append("serviceDate", getServiceDate())
            .toString();
    }
}
