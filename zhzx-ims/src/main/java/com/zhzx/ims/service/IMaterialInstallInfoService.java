package com.zhzx.ims.service;

import com.zhzx.ims.domain.MaterialInstallInfo;
import java.util.List;

/**
 * 安装信息Service接口
 * 
 * @author kiver
 * @date 2019-11-27
 */
public interface IMaterialInstallInfoService 
{
    /**
     * 查询安装信息
     * 
     * @param materialInstallInfoId 安装信息ID
     * @return 安装信息
     */
    public MaterialInstallInfo selectMaterialInstallInfoById(Long materialInstallInfoId);

    /**
     * 查询安装信息列表
     * 
     * @param materialInstallInfo 安装信息
     * @return 安装信息集合
     */
    public List<MaterialInstallInfo> selectMaterialInstallInfoList(MaterialInstallInfo materialInstallInfo);

    /**
     * 新增安装信息
     * 
     * @param materialInstallInfo 安装信息
     * @return 结果
     */
    public int insertMaterialInstallInfo(MaterialInstallInfo materialInstallInfo);

    /**
     * 修改安装信息
     * 
     * @param materialInstallInfo 安装信息
     * @return 结果
     */
    public int updateMaterialInstallInfo(MaterialInstallInfo materialInstallInfo);

    /**
     * 批量删除安装信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialInstallInfoByIds(String ids);

    /**
     * 删除安装信息信息
     * 
     * @param materialInstallInfoId 安装信息ID
     * @return 结果
     */
    public int deleteMaterialInstallInfoById(Long materialInstallInfoId);
}
