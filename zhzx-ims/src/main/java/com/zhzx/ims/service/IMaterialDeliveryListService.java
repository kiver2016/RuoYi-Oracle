package com.zhzx.ims.service;

import com.zhzx.ims.domain.MaterialDeliveryList;
import java.util.List;

/**
 * 送货清单Service接口
 * 
 * @author kiver
 * @date 2019-11-27
 */
public interface IMaterialDeliveryListService 
{
    /**
     * 查询送货清单
     * 
     * @param deliveryListId 送货清单ID
     * @return 送货清单
     */
    public MaterialDeliveryList selectMaterialDeliveryListById(Long deliveryListId);

    /**
     * 查询送货清单列表
     * 
     * @param materialDeliveryList 送货清单
     * @return 送货清单集合
     */
    public List<MaterialDeliveryList> selectMaterialDeliveryListList(MaterialDeliveryList materialDeliveryList);

    /**
     * 新增送货清单
     * 
     * @param materialDeliveryList 送货清单
     * @return 结果
     */
    public int insertMaterialDeliveryList(MaterialDeliveryList materialDeliveryList);

    /**
     * 修改送货清单
     * 
     * @param materialDeliveryList 送货清单
     * @return 结果
     */
    public int updateMaterialDeliveryList(MaterialDeliveryList materialDeliveryList);

    /**
     * 批量删除送货清单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialDeliveryListByIds(String ids);

    /**
     * 删除送货清单信息
     * 
     * @param deliveryListId 送货清单ID
     * @return 结果
     */
    public int deleteMaterialDeliveryListById(Long deliveryListId);

	public boolean updateMaterialStorageInfo(MaterialDeliveryList materialDeliveryList);

	public void updateMaterialOutStorage(MaterialDeliveryList materialDeliveryList);
}
