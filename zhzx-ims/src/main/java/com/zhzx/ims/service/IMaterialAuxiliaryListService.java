package com.zhzx.ims.service;

import com.zhzx.ims.domain.MaterialAuxiliaryList;
import java.util.List;

/**
 * 送货清单辅材Service接口
 * 
 * @author ruoyi
 * @date 2019-11-27
 */
public interface IMaterialAuxiliaryListService 
{
    /**
     * 查询送货清单辅材
     * 
     * @param materialAuxiliaryId 送货清单辅材ID
     * @return 送货清单辅材
     */
    public MaterialAuxiliaryList selectMaterialAuxiliaryListById(Long materialAuxiliaryId);

    /**
     * 查询送货清单辅材列表
     * 
     * @param materialAuxiliaryList 送货清单辅材
     * @return 送货清单辅材集合
     */
    public List<MaterialAuxiliaryList> selectMaterialAuxiliaryListList(MaterialAuxiliaryList materialAuxiliaryList);

    /**
     * 新增送货清单辅材
     * 
     * @param materialAuxiliaryList 送货清单辅材
     * @return 结果
     */
    public int insertMaterialAuxiliaryList(MaterialAuxiliaryList materialAuxiliaryList);

    /**
     * 修改送货清单辅材
     * 
     * @param materialAuxiliaryList 送货清单辅材
     * @return 结果
     */
    public int updateMaterialAuxiliaryList(MaterialAuxiliaryList materialAuxiliaryList);

    /**
     * 批量删除送货清单辅材
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialAuxiliaryListByIds(String ids);

    /**
     * 删除送货清单辅材信息
     * 
     * @param materialAuxiliaryId 送货清单辅材ID
     * @return 结果
     */
    public int deleteMaterialAuxiliaryListById(Long materialAuxiliaryId);

	public void BatchupdateMaterialAuxiliaryList(Long deliveryListId, String parentId);
}
