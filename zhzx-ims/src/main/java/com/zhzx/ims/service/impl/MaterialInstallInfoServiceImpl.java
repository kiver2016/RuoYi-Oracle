package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.MaterialInstallInfoMapper;
import com.zhzx.ims.domain.MaterialInstallInfo;
import com.zhzx.ims.service.IMaterialInstallInfoService;
import com.zhzx.common.core.text.Convert;

/**
 * 安装信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Service
public class MaterialInstallInfoServiceImpl implements IMaterialInstallInfoService 
{
    @Autowired
    private MaterialInstallInfoMapper materialInstallInfoMapper;

    /**
     * 查询安装信息
     * 
     * @param materialInstallInfoId 安装信息ID
     * @return 安装信息
     */
    @Override
    public MaterialInstallInfo selectMaterialInstallInfoById(Long materialInstallInfoId)
    {
        return materialInstallInfoMapper.selectMaterialInstallInfoById(materialInstallInfoId);
    }

    /**
     * 查询安装信息列表
     * 
     * @param materialInstallInfo 安装信息
     * @return 安装信息
     */
    @Override
    public List<MaterialInstallInfo> selectMaterialInstallInfoList(MaterialInstallInfo materialInstallInfo)
    {
        return materialInstallInfoMapper.selectMaterialInstallInfoList(materialInstallInfo);
    }

    /**
     * 新增安装信息
     * 
     * @param materialInstallInfo 安装信息
     * @return 结果
     */
    @Override
    public int insertMaterialInstallInfo(MaterialInstallInfo materialInstallInfo)
    {
        return materialInstallInfoMapper.insertMaterialInstallInfo(materialInstallInfo);
    }

    /**
     * 修改安装信息
     * 
     * @param materialInstallInfo 安装信息
     * @return 结果
     */
    @Override
    public int updateMaterialInstallInfo(MaterialInstallInfo materialInstallInfo)
    {
        return materialInstallInfoMapper.updateMaterialInstallInfo(materialInstallInfo);
    }

    /**
     * 删除安装信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialInstallInfoByIds(String ids)
    {
        return materialInstallInfoMapper.deleteMaterialInstallInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除安装信息信息
     * 
     * @param materialInstallInfoId 安装信息ID
     * @return 结果
     */
    @Override
    public int deleteMaterialInstallInfoById(Long materialInstallInfoId)
    {
        return materialInstallInfoMapper.deleteMaterialInstallInfoById(materialInstallInfoId);
    }
}
