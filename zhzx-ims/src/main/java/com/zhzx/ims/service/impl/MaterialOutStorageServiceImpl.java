package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.MaterialOutStorageMapper;
import com.zhzx.ims.domain.MaterialOutStorage;
import com.zhzx.ims.service.IMaterialOutStorageService;
import com.zhzx.common.core.text.Convert;

/**
 * 材料出库信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Service
public class MaterialOutStorageServiceImpl implements IMaterialOutStorageService 
{
    @Autowired
    private MaterialOutStorageMapper materialOutStorageMapper;

    /**
     * 查询材料出库信息
     * 
     * @param materialOutId 材料出库信息ID
     * @return 材料出库信息
     */
    @Override
    public MaterialOutStorage selectMaterialOutStorageById(Long materialOutId)
    {
        return materialOutStorageMapper.selectMaterialOutStorageById(materialOutId);
    }

    /**
     * 查询材料出库信息列表
     * 
     * @param materialOutStorage 材料出库信息
     * @return 材料出库信息
     */
    @Override
    public List<MaterialOutStorage> selectMaterialOutStorageList(MaterialOutStorage materialOutStorage)
    {
        return materialOutStorageMapper.selectMaterialOutStorageList(materialOutStorage);
    }

    /**
     * 新增材料出库信息
     * 
     * @param materialOutStorage 材料出库信息
     * @return 结果
     */
    @Override
    public int insertMaterialOutStorage(MaterialOutStorage materialOutStorage)
    {
        return materialOutStorageMapper.insertMaterialOutStorage(materialOutStorage);
    }

    /**
     * 修改材料出库信息
     * 
     * @param materialOutStorage 材料出库信息
     * @return 结果
     */
    @Override
    public int updateMaterialOutStorage(MaterialOutStorage materialOutStorage)
    {
        return materialOutStorageMapper.updateMaterialOutStorage(materialOutStorage);
    }

    /**
     * 删除材料出库信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialOutStorageByIds(String ids)
    {
        return materialOutStorageMapper.deleteMaterialOutStorageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材料出库信息信息
     * 
     * @param materialOutId 材料出库信息ID
     * @return 结果
     */
    @Override
    public int deleteMaterialOutStorageById(Long materialOutId)
    {
        return materialOutStorageMapper.deleteMaterialOutStorageById(materialOutId);
    }
}
