package com.zhzx.ims.service;

import com.zhzx.ims.domain.MaterialPutStorage;
import java.util.List;

/**
 * 材料入库信息Service接口
 * 
 * @author kiver
 * @date 2019-11-27
 */
public interface IMaterialPutStorageService 
{
    /**
     * 查询材料入库信息
     * 
     * @param materialPutId 材料入库信息ID
     * @return 材料入库信息
     */
    public MaterialPutStorage selectMaterialPutStorageById(Long materialPutId);

    /**
     * 查询材料入库信息列表
     * 
     * @param materialPutStorage 材料入库信息
     * @return 材料入库信息集合
     */
    public List<MaterialPutStorage> selectMaterialPutStorageList(MaterialPutStorage materialPutStorage);

    /**
     * 新增材料入库信息
     * 
     * @param materialPutStorage 材料入库信息
     * @return 结果
     */
    public int insertMaterialPutStorage(MaterialPutStorage materialPutStorage);

    /**
     * 修改材料入库信息
     * 
     * @param materialPutStorage 材料入库信息
     * @return 结果
     */
    public int updateMaterialPutStorage(MaterialPutStorage materialPutStorage);

    /**
     * 批量删除材料入库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialPutStorageByIds(String ids);

    /**
     * 删除材料入库信息信息
     * 
     * @param materialPutId 材料入库信息ID
     * @return 结果
     */
    public int deleteMaterialPutStorageById(Long materialPutId);
}
