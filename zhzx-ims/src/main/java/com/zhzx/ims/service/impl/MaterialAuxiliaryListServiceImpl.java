package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.MaterialAuxiliaryListMapper;
import com.zhzx.ims.domain.MaterialAuxiliaryList;
import com.zhzx.ims.service.IMaterialAuxiliaryListService;
import com.zhzx.common.core.text.Convert;

/**
 * 送货清单辅材Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-27
 */
@Service
public class MaterialAuxiliaryListServiceImpl implements IMaterialAuxiliaryListService 
{
    @Autowired
    private MaterialAuxiliaryListMapper materialAuxiliaryListMapper;

    /**
     * 查询送货清单辅材
     * 
     * @param materialAuxiliaryId 送货清单辅材ID
     * @return 送货清单辅材
     */
    @Override
    public MaterialAuxiliaryList selectMaterialAuxiliaryListById(Long materialAuxiliaryId)
    {
        return materialAuxiliaryListMapper.selectMaterialAuxiliaryListById(materialAuxiliaryId);
    }

    /**
     * 查询送货清单辅材列表
     * 
     * @param materialAuxiliaryList 送货清单辅材
     * @return 送货清单辅材
     */
    @Override
    public List<MaterialAuxiliaryList> selectMaterialAuxiliaryListList(MaterialAuxiliaryList materialAuxiliaryList)
    {
        return materialAuxiliaryListMapper.selectMaterialAuxiliaryListList(materialAuxiliaryList);
    }

    /**
     * 新增送货清单辅材
     * 
     * @param materialAuxiliaryList 送货清单辅材
     * @return 结果
     */
    @Override
    public int insertMaterialAuxiliaryList(MaterialAuxiliaryList materialAuxiliaryList)
    {
        return materialAuxiliaryListMapper.insertMaterialAuxiliaryList(materialAuxiliaryList);
    }

    /**
     * 修改送货清单辅材
     * 
     * @param materialAuxiliaryList 送货清单辅材
     * @return 结果
     */
    @Override
    public int updateMaterialAuxiliaryList(MaterialAuxiliaryList materialAuxiliaryList)
    {
        return materialAuxiliaryListMapper.updateMaterialAuxiliaryList(materialAuxiliaryList);
    }

    /**
     * 删除送货清单辅材对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialAuxiliaryListByIds(String ids)
    {
        return materialAuxiliaryListMapper.deleteMaterialAuxiliaryListByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除送货清单辅材信息
     * 
     * @param materialAuxiliaryId 送货清单辅材ID
     * @return 结果
     */
    @Override
    public int deleteMaterialAuxiliaryListById(Long materialAuxiliaryId)
    {
        return materialAuxiliaryListMapper.deleteMaterialAuxiliaryListById(materialAuxiliaryId);
    }

	@Override
	public void BatchupdateMaterialAuxiliaryList(Long deliveryListId, String parentId) {
		MaterialAuxiliaryList materialAuxiliaryList = new MaterialAuxiliaryList();
		materialAuxiliaryList.setParentId(parentId);
		List<MaterialAuxiliaryList> list = materialAuxiliaryListMapper.selectMaterialAuxiliaryListList(materialAuxiliaryList);
		for (MaterialAuxiliaryList materialAuxiliaryList2 : list) {
			materialAuxiliaryList2.setParentId(deliveryListId+"");
			materialAuxiliaryListMapper.updateMaterialAuxiliaryList(materialAuxiliaryList2);
		}
	}
}
