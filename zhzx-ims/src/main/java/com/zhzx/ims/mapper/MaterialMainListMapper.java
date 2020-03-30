package com.zhzx.ims.mapper;

import com.zhzx.ims.domain.MaterialMainList;
import java.util.List;

/**
 * 送货清单主材Mapper接口
 * 
 * @author kiver
 * @date 2019-11-27
 */
public interface MaterialMainListMapper 
{
    /**
     * 查询送货清单主材
     * 
     * @param materialMainId 送货清单主材ID
     * @return 送货清单主材
     */
    public MaterialMainList selectMaterialMainListById(Long materialMainId);

    /**
     * 查询送货清单主材列表
     * 
     * @param materialMainList 送货清单主材
     * @return 送货清单主材集合
     */
    public List<MaterialMainList> selectMaterialMainListList(MaterialMainList materialMainList);

    /**
     * 新增送货清单主材
     * 
     * @param materialMainList 送货清单主材
     * @return 结果
     */
    public int insertMaterialMainList(MaterialMainList materialMainList);

    /**
     * 修改送货清单主材
     * 
     * @param materialMainList 送货清单主材
     * @return 结果
     */
    public int updateMaterialMainList(MaterialMainList materialMainList);

    /**
     * 删除送货清单主材
     * 
     * @param materialMainId 送货清单主材ID
     * @return 结果
     */
    public int deleteMaterialMainListById(Long materialMainId);

    /**
     * 批量删除送货清单主材
     * 
     * @param materialMainIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialMainListByIds(String[] materialMainIds);
}
