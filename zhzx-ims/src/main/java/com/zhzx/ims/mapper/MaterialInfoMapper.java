package com.zhzx.ims.mapper;

import com.zhzx.ims.domain.MaterialInfo;
import java.util.List;

/**
 * 产品信息Mapper接口
 * 
 * @author kiver
 * @date 2019-11-27
 */
public interface MaterialInfoMapper 
{
    /**
     * 查询产品信息
     * 
     * @param materialId 产品信息ID
     * @return 产品信息
     */
    public MaterialInfo selectMaterialInfoById(Long materialId);

    /**
     * 查询产品信息列表
     * 
     * @param materialInfo 产品信息
     * @return 产品信息集合
     */
    public List<MaterialInfo> selectMaterialInfoList(MaterialInfo materialInfo);

    /**
     * 新增产品信息
     * 
     * @param materialInfo 产品信息
     * @return 结果
     */
    public int insertMaterialInfo(MaterialInfo materialInfo);

    /**
     * 修改产品信息
     * 
     * @param materialInfo 产品信息
     * @return 结果
     */
    public int updateMaterialInfo(MaterialInfo materialInfo);

    /**
     * 删除产品信息
     * 
     * @param materialId 产品信息ID
     * @return 结果
     */
    public int deleteMaterialInfoById(Long materialId);

    /**
     * 批量删除产品信息
     * 
     * @param materialIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialInfoByIds(String[] materialIds);
}
