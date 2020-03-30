package com.zhzx.ims.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;

/**
 * 付款信息对象 payment_info
 * 
 * @author kiver
 * @date 2019-12-04
 */
public class PaymentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long paymentInfoId;

    /** 付款日期 */
    @Excel(name = "付款日期")
    private Date paymentDate;

    /** 付款额度 */
    @Excel(name = "付款额度")
    private String paymentLimit;

    private String parentId;
    
    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
    public void setPaymentInfoId(Long paymentInfoId) 
    {
        this.paymentInfoId = paymentInfoId;
    }

    public Long getPaymentInfoId() 
    {
        return paymentInfoId;
    }
    public void setPaymentDate(Date paymentDate) 
    {
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() 
    {
        return paymentDate;
    }
    public void setPaymentLimit(String paymentLimit) 
    {
        this.paymentLimit = paymentLimit;
    }

    public String getPaymentLimit() 
    {
        return paymentLimit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("paymentInfoId", getPaymentInfoId())
            .append("paymentDate", getPaymentDate())
            .append("paymentLimit", getPaymentLimit())
            .toString();
    }
}
