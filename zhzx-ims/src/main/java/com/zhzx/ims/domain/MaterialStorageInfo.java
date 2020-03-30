package com.zhzx.ims.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhzx.common.annotation.Excel;
import com.zhzx.common.core.domain.BaseEntity;

/**
 * 库存信息对象 material_storage_info
 * 
 * @author kiver
 * @date 2019-12-06
 */
public class MaterialStorageInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long materialStorageInfoId;

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

    /** 入库数量 */
    @Excel(name = "入库数量")
    private String materialPutNum;

    /** 出库数量 */
    @Excel(name = "出库数量")
    private String materialOutNum;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private String materialStorageNum;

    /** 库房 */
    @Excel(name = "库房")
    private String storage;

    public void setMaterialStorageInfoId(Long materialStorageInfoId) 
    {
        this.materialStorageInfoId = materialStorageInfoId;
    }

    public Long getMaterialStorageInfoId() 
    {
        return materialStorageInfoId;
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
    public void setMaterialPutNum(String materialPutNum) 
    {
        this.materialPutNum = materialPutNum;
    }

    public String getMaterialPutNum() 
    {
        return materialPutNum;
    }
    public void setMaterialOutNum(String materialOutNum) 
    {
        this.materialOutNum = materialOutNum;
    }

    public String getMaterialOutNum() 
    {
        return materialOutNum;
    }
    public void setMaterialStorageNum(String materialStorageNum) 
    {
        this.materialStorageNum = materialStorageNum;
    }

    public String getMaterialStorageNum() 
    {
        return materialStorageNum;
    }
    public void setStorage(String storage) 
    {
        this.storage = storage;
    }

    public String getStorage() 
    {
        return storage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialStorageInfoId", getMaterialStorageInfoId())
            .append("materialName", getMaterialName())
            .append("materialBrand", getMaterialBrand())
            .append("materialModel", getMaterialModel())
            .append("materialNorms", getMaterialNorms())
            .append("materialLargeClass", getMaterialLargeClass())
            .append("materialSubClass", getMaterialSubClass())
            .append("materialPutNum", getMaterialPutNum())
            .append("materialOutNum", getMaterialOutNum())
            .append("materialStorageNum", getMaterialStorageNum())
            .append("storage", getStorage())
            .toString();
    }
}
