package com.zhzx.ims.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;

/**
 * 合同信息对象 contract_info
 * 
 * @author kiver
 * @date 2019-12-04
 */
public class ContractInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long contractInfoId;

    /** 合同签订日期 */
    @Excel(name = "合同签订日期")
    private Date contractDate;

    /** 合同额度 */
    @Excel(name = "合同额度")
    private String contractLimit;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String paymentMethod;

    /** 销售员 */
    @Excel(name = "销售员")
    private String salesperson;

    /** 父表ID */
    @Excel(name = "父表ID")
    private String parentId;

    /** 顾客名称 */
    @Excel(name = "顾客名称")
    private String customer;
    
    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;
    
    /** 地址 */
    @Excel(name = "地址")
    private String address;
    
    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNum;
    
    public void setContractInfoId(Long contractInfoId) 
    {
        this.contractInfoId = contractInfoId;
    }

    public Long getContractInfoId() 
    {
        return contractInfoId;
    }
    public void setContractDate(Date contractDate) 
    {
        this.contractDate = contractDate;
    }

    public Date getContractDate() 
    {
        return contractDate;
    }
    public void setContractLimit(String contractLimit) 
    {
        this.contractLimit = contractLimit;
    }

    public String getContractLimit() 
    {
        return contractLimit;
    }
    public void setPaymentMethod(String paymentMethod) 
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }
    public void setSalesperson(String salesperson) 
    {
        this.salesperson = salesperson;
    }

    public String getSalesperson() 
    {
        return salesperson;
    }
    public void setParentId(String parentId) 
    {
        this.parentId = parentId;
    }

    public String getParentId() 
    {
        return parentId;
    }

    public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractInfoId", getContractInfoId())
            .append("contractDate", getContractDate())
            .append("contractLimit", getContractLimit())
            .append("paymentMethod", getPaymentMethod())
            .append("salesperson", getSalesperson())
            .append("remark", getRemark())
            .append("parentId", getParentId())
            .append("customer", getCustomer())
            .append("phone", getPhone())
            .append("address", getAddress())
            .append("contractNum", getContractNum())
            .toString();
    }
}
