package com.zhzx.ims.service;

import com.zhzx.ims.domain.MaterialPutStorage;
import com.zhzx.ims.domain.MaterialPutStorageSub;
import java.util.List;

/**
 * 材料入库信息子Service接口
 * 
 * @author kiver
 * @date 2019-11-27
 */
public interface IMaterialPutStorageSubService 
{
    /**
     * 查询材料入库信息子
     * 
     * @param materialPutSubId 材料入库信息子ID
     * @return 材料入库信息子
     */
    public MaterialPutStorageSub selectMaterialPutStorageSubById(Long materialPutSubId);

    /**
     * 查询材料入库信息子列表
     * 
     * @param materialPutStorageSub 材料入库信息子
     * @return 材料入库信息子集合
     */
    public List<MaterialPutStorageSub> selectMaterialPutStorageSubList(MaterialPutStorageSub materialPutStorageSub);

    /**
     * 新增材料入库信息子
     * 
     * @param materialPutStorageSub 材料入库信息子
     * @return 结果
     */
    public int insertMaterialPutStorageSub(MaterialPutStorageSub materialPutStorageSub);

    /**
     * 修改材料入库信息子
     * 
     * @param materialPutStorageSub 材料入库信息子
     * @return 结果
     */
    public int updateMaterialPutStorageSub(MaterialPutStorageSub materialPutStorageSub);

    /**
     * 批量删除材料入库信息子
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialPutStorageSubByIds(String ids);

    /**
     * 删除材料入库信息子信息
     * 
     * @param materialPutSubId 材料入库信息子ID
     * @return 结果
     */
    public int deleteMaterialPutStorageSubById(Long materialPutSubId);

	public void BatchupdateMaterialPutStorageSub(String parentId, MaterialPutStorage materialPutStorage);

	public void deleteMaterialPutStorageSubByParentIds(String ids);

}
