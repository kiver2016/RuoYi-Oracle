package com.zhzx.ims.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.MaterialDeliveryListMapper;
import com.zhzx.ims.mapper.MaterialMainListMapper;
import com.zhzx.ims.mapper.MaterialOutStorageMapper;
import com.zhzx.ims.mapper.MaterialStorageInfoMapper;
import com.zhzx.ims.domain.MaterialDeliveryList;
import com.zhzx.ims.domain.MaterialMainList;
import com.zhzx.ims.domain.MaterialOutStorage;
import com.zhzx.ims.domain.MaterialStorageInfo;
import com.zhzx.ims.service.IMaterialDeliveryListService;
import com.zhzx.common.core.text.Convert;

/**
 * 送货清单Service业务层处理
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Service
public class MaterialDeliveryListServiceImpl implements IMaterialDeliveryListService 
{
    @Autowired
    private MaterialDeliveryListMapper materialDeliveryListMapper;
    @Autowired
    private MaterialStorageInfoMapper materialStorageInfoMapper;
    @Autowired
    private MaterialMainListMapper materialMainListMapper;
    @Autowired
    private MaterialOutStorageMapper materialOutStorageMapper;
    /**
     * 查询送货清单
     * 
     * @param deliveryListId 送货清单ID
     * @return 送货清单
     */
    @Override
    public MaterialDeliveryList selectMaterialDeliveryListById(Long deliveryListId)
    {
        return materialDeliveryListMapper.selectMaterialDeliveryListById(deliveryListId);
    }

    /**
     * 查询送货清单列表
     * 
     * @param materialDeliveryList 送货清单
     * @return 送货清单
     */
    @Override
    public List<MaterialDeliveryList> selectMaterialDeliveryListList(MaterialDeliveryList materialDeliveryList)
    {
        return materialDeliveryListMapper.selectMaterialDeliveryListList(materialDeliveryList);
    }

    /**
     * 新增送货清单
     * 
     * @param materialDeliveryList 送货清单
     * @return 结果
     */
    @Override
    public int insertMaterialDeliveryList(MaterialDeliveryList materialDeliveryList)
    {
        return materialDeliveryListMapper.insertMaterialDeliveryList(materialDeliveryList);
    }

    /**
     * 修改送货清单
     * 
     * @param materialDeliveryList 送货清单
     * @return 结果
     */
    @Override
    public int updateMaterialDeliveryList(MaterialDeliveryList materialDeliveryList)
    {
        return materialDeliveryListMapper.updateMaterialDeliveryList(materialDeliveryList);
    }

    /**
     * 删除送货清单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialDeliveryListByIds(String ids)
    {
        return materialDeliveryListMapper.deleteMaterialDeliveryListByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除送货清单信息
     * 
     * @param deliveryListId 送货清单ID
     * @return 结果
     */
    @Override
    public int deleteMaterialDeliveryListById(Long deliveryListId)
    {
        return materialDeliveryListMapper.deleteMaterialDeliveryListById(deliveryListId);
    }

	@Override
	public boolean updateMaterialStorageInfo(MaterialDeliveryList materialDeliveryList) {
		MaterialMainList materialMainList = new MaterialMainList();
		materialMainList.setParentId(materialDeliveryList.getDeliveryListId().toString());
		List<MaterialMainList> materialMainLists = materialMainListMapper.selectMaterialMainListList(materialMainList);
		for (MaterialMainList materialMainList2 : materialMainLists) {
			MaterialStorageInfo materialStorageInfo = new MaterialStorageInfo();
			materialStorageInfo.setMaterialBrand(materialDeliveryList.getMaterialBrand());
			materialStorageInfo.setStorage(materialDeliveryList.getStorage());
			materialStorageInfo.setMaterialName(materialMainList2.getMaterialName());
			materialStorageInfo.setMaterialNorms(materialMainList2.getMaterialNorms());
			List<MaterialStorageInfo> materialStorageInfos =materialStorageInfoMapper.selectMaterialStorageInfoList(materialStorageInfo);
			for (MaterialStorageInfo materialStorageInfo2 : materialStorageInfos) {
				String materialOutNum = materialStorageInfo2.getMaterialOutNum();//出库中的出库数量
				String materialNum = materialMainList2.getMaterialNum();//实时出库数量
				String materialStorageNum = materialStorageInfo2.getMaterialStorageNum();//库存数量
				materialStorageInfo2.setMaterialOutNum((Double.parseDouble(materialOutNum==null?"0":materialOutNum)+Double.parseDouble(materialNum))+"");
				materialStorageInfo2.setMaterialStorageNum((Double.parseDouble(materialStorageNum==null?"0":materialStorageNum)-Double.parseDouble(materialNum))+"");
				materialStorageInfoMapper.updateMaterialStorageInfo(materialStorageInfo2);
			}
		}
		return true;
	}

	@Override
	public void updateMaterialOutStorage(MaterialDeliveryList materialDeliveryList) {
		materialDeliveryList = materialDeliveryListMapper.selectMaterialDeliveryListById(materialDeliveryList.getDeliveryListId());
		MaterialMainList materialMainList = new MaterialMainList();
		materialMainList.setParentId(materialDeliveryList.getDeliveryListId().toString());
		List<MaterialMainList> materialMainLists = materialMainListMapper.selectMaterialMainListList(materialMainList);
		for (MaterialMainList materialMainList2 : materialMainLists) {
			MaterialOutStorage materialOutStorage =new MaterialOutStorage();
			materialOutStorage.setMaterialName(materialMainList2.getMaterialName());
			materialOutStorage.setMaterialModel(materialMainList2.getMaterialModel());
			materialOutStorage.setMaterialNorms(materialMainList2.getMaterialNorms());
			materialOutStorage.setMaterialLargeClass(materialMainList2.getMaterialLargeClass());
			materialOutStorage.setMaterialSubClass(materialMainList2.getMaterialSubClass());
			materialOutStorage.setStorage(materialDeliveryList.getStorage());
			materialOutStorage.setOutNum(materialMainList2.getMaterialNum());
			materialOutStorage.setMaterialOutDate(new Date(System.currentTimeMillis()));
			materialOutStorage.setCustomer(materialDeliveryList.getCustomer());
			materialOutStorage.setDeliveryPlace(materialDeliveryList.getAddress());
			materialOutStorage.settCost("");
			materialOutStorage.setOperoter(materialDeliveryList.getStorageManger());
			materialOutStorageMapper.insertMaterialOutStorage(materialOutStorage);		
		}
	}
}
