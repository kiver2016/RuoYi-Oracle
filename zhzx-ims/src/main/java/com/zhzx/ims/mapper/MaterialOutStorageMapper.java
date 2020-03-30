package com.zhzx.ims.mapper;

import com.zhzx.ims.domain.MaterialOutStorage;
import java.util.List;

/**
 * 材料出库信息Mapper接口
 * 
 * @author kiver
 * @date 2019-11-27
 */
public interface MaterialOutStorageMapper 
{
    /**
     * 查询材料出库信息
     * 
     * @param materialOutId 材料出库信息ID
     * @return 材料出库信息
     */
    public MaterialOutStorage selectMaterialOutStorageById(Long materialOutId);

    /**
     * 查询材料出库信息列表
     * 
     * @param materialOutStorage 材料出库信息
     * @return 材料出库信息集合
     */
    public List<MaterialOutStorage> selectMaterialOutStorageList(MaterialOutStorage materialOutStorage);

    /**
     * 新增材料出库信息
     * 
     * @param materialOutStorage 材料出库信息
     * @return 结果
     */
    public int insertMaterialOutStorage(MaterialOutStorage materialOutStorage);

    /**
     * 修改材料出库信息
     * 
     * @param materialOutStorage 材料出库信息
     * @return 结果
     */
    public int updateMaterialOutStorage(MaterialOutStorage materialOutStorage);

    /**
     * 删除材料出库信息
     * 
     * @param materialOutId 材料出库信息ID
     * @return 结果
     */
    public int deleteMaterialOutStorageById(Long materialOutId);

    /**
     * 批量删除材料出库信息
     * 
     * @param materialOutIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialOutStorageByIds(String[] materialOutIds);
}
