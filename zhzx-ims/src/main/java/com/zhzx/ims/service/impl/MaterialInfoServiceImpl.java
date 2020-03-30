package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.MaterialInfoMapper;
import com.zhzx.ims.domain.MaterialInfo;
import com.zhzx.ims.service.IMaterialInfoService;
import com.zhzx.common.core.text.Convert;

/**
 * 产品信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Service
public class MaterialInfoServiceImpl implements IMaterialInfoService 
{
    @Autowired
    private MaterialInfoMapper materialInfoMapper;

    /**
     * 查询产品信息
     * 
     * @param materialId 产品信息ID
     * @return 产品信息
     */
    @Override
    public MaterialInfo selectMaterialInfoById(Long materialId)
    {
        return materialInfoMapper.selectMaterialInfoById(materialId);
    }

    /**
     * 查询产品信息列表
     * 
     * @param materialInfo 产品信息
     * @return 产品信息
     */
    @Override
    public List<MaterialInfo> selectMaterialInfoList(MaterialInfo materialInfo)
    {
        return materialInfoMapper.selectMaterialInfoList(materialInfo);
    }

    /**
     * 新增产品信息
     * 
     * @param materialInfo 产品信息
     * @return 结果
     */
    @Override
    public int insertMaterialInfo(MaterialInfo materialInfo)
    {
        return materialInfoMapper.insertMaterialInfo(materialInfo);
    }

    /**
     * 修改产品信息
     * 
     * @param materialInfo 产品信息
     * @return 结果
     */
    @Override
    public int updateMaterialInfo(MaterialInfo materialInfo)
    {
        return materialInfoMapper.updateMaterialInfo(materialInfo);
    }

    /**
     * 删除产品信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialInfoByIds(String ids)
    {
        return materialInfoMapper.deleteMaterialInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息信息
     * 
     * @param materialId 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteMaterialInfoById(Long materialId)
    {
        return materialInfoMapper.deleteMaterialInfoById(materialId);
    }
}
