package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhzx.ims.mapper.MaterialPutStorageMapper;
import com.zhzx.ims.mapper.MaterialPutStorageSubMapper;
import com.zhzx.ims.mapper.MaterialStorageInfoMapper;
import com.zhzx.ims.domain.MaterialPutStorage;
import com.zhzx.ims.domain.MaterialPutStorageSub;
import com.zhzx.ims.domain.MaterialStorageInfo;
import com.zhzx.ims.service.IMaterialStorageInfoService;
import com.zhzx.common.core.text.Convert;

/**
 * 库存信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-12-06
 */
@Service
public class MaterialStorageInfoServiceImpl implements IMaterialStorageInfoService 
{
    @Autowired
    private MaterialStorageInfoMapper materialStorageInfoMapper;
    @Autowired
    private MaterialPutStorageSubMapper materialPutStorageSubMapper;
    /**
     * 查询库存信息
     * 
     * @param materialStorageInfoId 库存信息ID
     * @return 库存信息
     */
    @Override
    public MaterialStorageInfo selectMaterialStorageInfoById(Long materialStorageInfoId)
    {
        return materialStorageInfoMapper.selectMaterialStorageInfoById(materialStorageInfoId);
    }

    /**
     * 查询库存信息列表
     * 
     * @param materialStorageInfo 库存信息
     * @return 库存信息
     */
    @Override
    public List<MaterialStorageInfo> selectMaterialStorageInfoList(MaterialStorageInfo materialStorageInfo)
    {
        return materialStorageInfoMapper.selectMaterialStorageInfoList(materialStorageInfo);
    }

    /**
     * 新增库存信息
     * 
     * @param materialStorageInfo 库存信息
     * @return 结果
     */
    @Override
    public int insertMaterialStorageInfo(MaterialStorageInfo materialStorageInfo)
    {
        return materialStorageInfoMapper.insertMaterialStorageInfo(materialStorageInfo);
    }

    /**
     * 修改库存信息
     * 
     * @param materialStorageInfo 库存信息
     * @return 结果
     */
    @Override
    public int updateMaterialStorageInfo(MaterialStorageInfo materialStorageInfo)
    {
        return materialStorageInfoMapper.updateMaterialStorageInfo(materialStorageInfo);
    }

    /**
     * 删除库存信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialStorageInfoByIds(String ids)
    {
        return materialStorageInfoMapper.deleteMaterialStorageInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除库存信息信息
     * 
     * @param materialStorageInfoId 库存信息ID
     * @return 结果
     */
    @Override
    public int deleteMaterialStorageInfoById(Long materialStorageInfoId)
    {
        return materialStorageInfoMapper.deleteMaterialStorageInfoById(materialStorageInfoId);
    }

	@Override
	public void savePutStorage(MaterialPutStorage materialPutStorage) {
		MaterialPutStorageSub materialPutStorageSub = new MaterialPutStorageSub();
		materialPutStorageSub.setParentId(materialPutStorage.getMaterialPutId()+"");
		List<MaterialPutStorageSub> materialPutStorageSubList = materialPutStorageSubMapper.selectMaterialPutStorageSubList(materialPutStorageSub);
		for (MaterialPutStorageSub materialPutStorageSub2 : materialPutStorageSubList) {
			MaterialStorageInfo materialStorageInfo = new MaterialStorageInfo();
			materialStorageInfo.setMaterialName(materialPutStorageSub2.getMaterialName());
			materialStorageInfo.setMaterialBrand(materialPutStorageSub2.getMaterialBrand());
			materialStorageInfo.setMaterialModel(materialPutStorageSub2.getMaterialModel());
			materialStorageInfo.setMaterialNorms(materialPutStorageSub2.getMaterialNorms());
			materialStorageInfo.setMaterialLargeClass(materialPutStorageSub2.getMaterialLargeClass());
			materialStorageInfo.setMaterialSubClass(materialPutStorageSub2.getMaterialSubClass());
			materialStorageInfo.setStorage(materialPutStorage.getStorage());
			List<MaterialStorageInfo> materialStorageInfoList = materialStorageInfoMapper.selectMaterialStorageInfoList(materialStorageInfo);
			if (materialStorageInfoList.size()<1) {
				materialStorageInfo.setMaterialPutNum(materialPutStorageSub2.getPutNum());
				materialStorageInfo.setMaterialStorageNum(materialPutStorageSub2.getPutNum());
				materialStorageInfoMapper.insertMaterialStorageInfo(materialStorageInfo);
			}else {
				for (MaterialStorageInfo materialStorageInfo2 : materialStorageInfoList) {
					double materialPutNum = Double.parseDouble(materialStorageInfo2.getMaterialPutNum())+Double.parseDouble(materialPutStorageSub2.getPutNum());
					double materialStorageNum = Double.parseDouble(materialStorageInfo2.getMaterialStorageNum())+Double.parseDouble(materialPutStorageSub2.getPutNum());
					materialStorageInfo.setMaterialPutNum(materialPutNum+"");
					materialStorageInfo.setMaterialStorageNum(materialStorageNum+"");
					materialStorageInfo.setMaterialStorageInfoId(materialStorageInfo2.getMaterialStorageInfoId());
					materialStorageInfoMapper.updateMaterialStorageInfo(materialStorageInfo);
				}
			}
		}
	}
}
