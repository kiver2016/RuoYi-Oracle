package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.MaterialPutStorageSubMapper;
import com.zhzx.ims.domain.MaterialPutStorage;
import com.zhzx.ims.domain.MaterialPutStorageSub;
import com.zhzx.ims.service.IMaterialPutStorageSubService;
import com.zhzx.common.core.text.Convert;

/**
 * 材料入库信息子Service业务层处理
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Service
public class MaterialPutStorageSubServiceImpl implements IMaterialPutStorageSubService 
{
    @Autowired
    private MaterialPutStorageSubMapper materialPutStorageSubMapper;

    /**
     * 查询材料入库信息子
     * 
     * @param materialPutSubId 材料入库信息子ID
     * @return 材料入库信息子
     */
    @Override
    public MaterialPutStorageSub selectMaterialPutStorageSubById(Long materialPutSubId)
    {
        return materialPutStorageSubMapper.selectMaterialPutStorageSubById(materialPutSubId);
    }

    /**
     * 查询材料入库信息子列表
     * 
     * @param materialPutStorageSub 材料入库信息子
     * @return 材料入库信息子
     */
    @Override
    public List<MaterialPutStorageSub> selectMaterialPutStorageSubList(MaterialPutStorageSub materialPutStorageSub)
    {
        return materialPutStorageSubMapper.selectMaterialPutStorageSubList(materialPutStorageSub);
    }

    /**
     * 新增材料入库信息子
     * 
     * @param materialPutStorageSub 材料入库信息子
     * @return 结果
     */
    @Override
    public int insertMaterialPutStorageSub(MaterialPutStorageSub materialPutStorageSub)
    {
        return materialPutStorageSubMapper.insertMaterialPutStorageSub(materialPutStorageSub);
    }

    /**
     * 修改材料入库信息子
     * 
     * @param materialPutStorageSub 材料入库信息子
     * @return 结果
     */
    @Override
    public int updateMaterialPutStorageSub(MaterialPutStorageSub materialPutStorageSub)
    {
        return materialPutStorageSubMapper.updateMaterialPutStorageSub(materialPutStorageSub);
    }

    /**
     * 删除材料入库信息子对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialPutStorageSubByIds(String ids)
    {
        return materialPutStorageSubMapper.deleteMaterialPutStorageSubByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材料入库信息子信息
     * 
     * @param materialPutSubId 材料入库信息子ID
     * @return 结果
     */
    @Override
    public int deleteMaterialPutStorageSubById(Long materialPutSubId)
    {
        return materialPutStorageSubMapper.deleteMaterialPutStorageSubById(materialPutSubId);
    }

	@Override
	public void BatchupdateMaterialPutStorageSub(String parentId,MaterialPutStorage materialPutStorage) {
		MaterialPutStorageSub materialPutStorageSub = new MaterialPutStorageSub();
		materialPutStorageSub.setParentId(parentId);
		List<MaterialPutStorageSub> list = materialPutStorageSubMapper.selectMaterialPutStorageSubList(materialPutStorageSub);
		for (MaterialPutStorageSub materialPutStorageSub2 : list) {
			materialPutStorageSub2.setParentId(materialPutStorage.getMaterialPutId()+"");
			materialPutStorageSub2.setMaterialPutDate(materialPutStorage.getMaterialPutDate());//入库时间
			materialPutStorageSub2.setMaterialBrand(materialPutStorage.getMaterialBrand());//品牌
			materialPutStorageSub2.setStorage(materialPutStorage.getStorage());//库房
			materialPutStorageSubMapper.updateMaterialPutStorageSub(materialPutStorageSub2);
		}
	}

	@Override
	public void deleteMaterialPutStorageSubByParentIds(String ids) {
		materialPutStorageSubMapper.deleteMaterialPutStorageSubByParentIds(Convert.toStrArray(ids));		
	}
}
