package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;

/**
 * 合同产品及送货信息对象 contract_material_info
 * 
 * @author kiver
 * @date 2019-12-04
 */
public class ContractMaterialInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long contractMaterialInfoId;

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

    /** 合同数量 */
    @Excel(name = "合同数量")
    private String contractNum;

    /** 已送货数量 */
    @Excel(name = "已送货数量")
    private String deliverGoods;

    private String parentId;
    
    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setContractMaterialInfoId(Long contractMaterialInfoId) 
    {
        this.contractMaterialInfoId = contractMaterialInfoId;
    }

    public Long getContractMaterialInfoId() 
    {
        return contractMaterialInfoId;
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
    public void setContractNum(String contractNum) 
    {
        this.contractNum = contractNum;
    }

    public String getContractNum() 
    {
        return contractNum;
    }
    public void setDeliverGoods(String deliverGoods) 
    {
        this.deliverGoods = deliverGoods;
    }

    public String getDeliverGoods() 
    {
        return deliverGoods;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractMaterialInfoId", getContractMaterialInfoId())
            .append("materialName", getMaterialName())
            .append("materialBrand", getMaterialBrand())
            .append("materialModel", getMaterialModel())
            .append("materialNorms", getMaterialNorms())
            .append("contractNum", getContractNum())
            .append("deliverGoods", getDeliverGoods())
            .toString();
    }
}
