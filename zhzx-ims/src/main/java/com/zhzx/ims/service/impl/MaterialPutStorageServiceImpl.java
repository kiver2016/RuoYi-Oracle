package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.MaterialPutStorageMapper;
import com.zhzx.ims.domain.MaterialPutStorage;
import com.zhzx.ims.service.IMaterialPutStorageService;
import com.zhzx.common.core.text.Convert;

/**
 * 材料入库信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Service
public class MaterialPutStorageServiceImpl implements IMaterialPutStorageService 
{
    @Autowired
    private MaterialPutStorageMapper materialPutStorageMapper;

    /**
     * 查询材料入库信息
     * 
     * @param materialPutId 材料入库信息ID
     * @return 材料入库信息
     */
    @Override
    public MaterialPutStorage selectMaterialPutStorageById(Long materialPutId)
    {
        return materialPutStorageMapper.selectMaterialPutStorageById(materialPutId);
    }

    /**
     * 查询材料入库信息列表
     * 
     * @param materialPutStorage 材料入库信息
     * @return 材料入库信息
     */
    @Override
    public List<MaterialPutStorage> selectMaterialPutStorageList(MaterialPutStorage materialPutStorage)
    {
        return materialPutStorageMapper.selectMaterialPutStorageList(materialPutStorage);
    }

    /**
     * 新增材料入库信息
     * 
     * @param materialPutStorage 材料入库信息
     * @return 结果
     */
    @Override
    public int insertMaterialPutStorage(MaterialPutStorage materialPutStorage)
    {
        return materialPutStorageMapper.insertMaterialPutStorage(materialPutStorage);
    }

    /**
     * 修改材料入库信息
     * 
     * @param materialPutStorage 材料入库信息
     * @return 结果
     */
    @Override
    public int updateMaterialPutStorage(MaterialPutStorage materialPutStorage)
    {
        return materialPutStorageMapper.updateMaterialPutStorage(materialPutStorage);
    }

    /**
     * 删除材料入库信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialPutStorageByIds(String ids)
    {
        return materialPutStorageMapper.deleteMaterialPutStorageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材料入库信息信息
     * 
     * @param materialPutId 材料入库信息ID
     * @return 结果
     */
    @Override
    public int deleteMaterialPutStorageById(Long materialPutId)
    {
        return materialPutStorageMapper.deleteMaterialPutStorageById(materialPutId);
    }
}
