package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;

/**
 * 产品信息对象 material_info
 * 
 * @author kiver
 * @date 2019-11-27
 */
public class MaterialInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long materialId;

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

    /** 产品大类 */
    @Excel(name = "产品大类")
    private String materialLargeClass;

    /** 产品小类 */
    @Excel(name = "产品小类")
    private String materialSubClass;

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("materialBrand", getMaterialBrand())
            .append("materialModel", getMaterialModel())
            .append("materialNorms", getMaterialNorms())
            .append("materialLargeClass", getMaterialLargeClass())
            .append("materialSubClass", getMaterialSubClass())
            .toString();
    }
}
