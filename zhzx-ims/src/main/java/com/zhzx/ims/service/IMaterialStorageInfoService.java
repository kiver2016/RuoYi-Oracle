package com.zhzx.ims.service;

import com.zhzx.ims.domain.MaterialPutStorage;
import com.zhzx.ims.domain.MaterialStorageInfo;
import java.util.List;

/**
 * 库存信息Service接口
 * 
 * @author kiver
 * @date 2019-12-06
 */
public interface IMaterialStorageInfoService 
{
    /**
     * 查询库存信息
     * 
     * @param materialStorageInfoId 库存信息ID
     * @return 库存信息
     */
    public MaterialStorageInfo selectMaterialStorageInfoById(Long materialStorageInfoId);

    /**
     * 查询库存信息列表
     * 
     * @param materialStorageInfo 库存信息
     * @return 库存信息集合
     */
    public List<MaterialStorageInfo> selectMaterialStorageInfoList(MaterialStorageInfo materialStorageInfo);

    /**
     * 新增库存信息
     * 
     * @param materialStorageInfo 库存信息
     * @return 结果
     */
    public int insertMaterialStorageInfo(MaterialStorageInfo materialStorageInfo);

    /**
     * 修改库存信息
     * 
     * @param materialStorageInfo 库存信息
     * @return 结果
     */
    public int updateMaterialStorageInfo(MaterialStorageInfo materialStorageInfo);

    /**
     * 批量删除库存信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialStorageInfoByIds(String ids);

    /**
     * 删除库存信息信息
     * 
     * @param materialStorageInfoId 库存信息ID
     * @return 结果
     */
    public int deleteMaterialStorageInfoById(Long materialStorageInfoId);

	public void savePutStorage(MaterialPutStorage materialPutStorage);

}
