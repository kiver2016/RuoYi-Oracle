package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.MaterialMainListMapper;
import com.zhzx.ims.domain.MaterialMainList;
import com.zhzx.ims.service.IMaterialMainListService;
import com.zhzx.common.core.text.Convert;

/**
 * 送货清单主材Service业务层处理
 * 
 * @author kiver
 * @date 2019-11-27
 */
@Service
public class MaterialMainListServiceImpl implements IMaterialMainListService 
{
    @Autowired
    private MaterialMainListMapper materialMainListMapper;

    /**
     * 查询送货清单主材
     * 
     * @param materialMainId 送货清单主材ID
     * @return 送货清单主材
     */
    @Override
    public MaterialMainList selectMaterialMainListById(Long materialMainId)
    {
        return materialMainListMapper.selectMaterialMainListById(materialMainId);
    }

    /**
     * 查询送货清单主材列表
     * 
     * @param materialMainList 送货清单主材
     * @return 送货清单主材
     */
    @Override
    public List<MaterialMainList> selectMaterialMainListList(MaterialMainList materialMainList)
    {
        return materialMainListMapper.selectMaterialMainListList(materialMainList);
    }

    /**
     * 新增送货清单主材
     * 
     * @param materialMainList 送货清单主材
     * @return 结果
     */
    @Override
    public int insertMaterialMainList(MaterialMainList materialMainList)
    {
        return materialMainListMapper.insertMaterialMainList(materialMainList);
    }

    /**
     * 修改送货清单主材
     * 
     * @param materialMainList 送货清单主材
     * @return 结果
     */
    @Override
    public int updateMaterialMainList(MaterialMainList materialMainList)
    {
        return materialMainListMapper.updateMaterialMainList(materialMainList);
    }

    /**
     * 删除送货清单主材对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialMainListByIds(String ids)
    {
        return materialMainListMapper.deleteMaterialMainListByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除送货清单主材信息
     * 
     * @param materialMainId 送货清单主材ID
     * @return 结果
     */
    @Override
    public int deleteMaterialMainListById(Long materialMainId)
    {
        return materialMainListMapper.deleteMaterialMainListById(materialMainId);
    }

	@Override
	public void BatchupdateMaterialMainList(Long deliveryListId, String parentId) {
		MaterialMainList materialMainList = new MaterialMainList();
		materialMainList.setParentId(parentId);
		List<MaterialMainList> list = materialMainListMapper.selectMaterialMainListList(materialMainList);
		for (MaterialMainList materialMainList2 : list) {
			materialMainList2.setParentId(deliveryListId+"");
			materialMainListMapper.updateMaterialMainList(materialMainList2);
		}
	}
}
