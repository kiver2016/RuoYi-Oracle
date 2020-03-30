package com.zhzx.ims.service;

import com.zhzx.ims.domain.ContractMaterialInfo;
import java.util.List;

/**
 * 合同产品及送货信息Service接口
 * 
 * @author kiver
 * @date 2019-12-04
 */
public interface IContractMaterialInfoService 
{
    /**
     * 查询合同产品及送货信息
     * 
     * @param contractMaterialInfoId 合同产品及送货信息ID
     * @return 合同产品及送货信息
     */
    public ContractMaterialInfo selectContractMaterialInfoById(Long contractMaterialInfoId);

    /**
     * 查询合同产品及送货信息列表
     * 
     * @param contractMaterialInfo 合同产品及送货信息
     * @return 合同产品及送货信息集合
     */
    public List<ContractMaterialInfo> selectContractMaterialInfoList(ContractMaterialInfo contractMaterialInfo);

    /**
     * 新增合同产品及送货信息
     * 
     * @param contractMaterialInfo 合同产品及送货信息
     * @return 结果
     */
    public int insertContractMaterialInfo(ContractMaterialInfo contractMaterialInfo);

    /**
     * 修改合同产品及送货信息
     * 
     * @param contractMaterialInfo 合同产品及送货信息
     * @return 结果
     */
    public int updateContractMaterialInfo(ContractMaterialInfo contractMaterialInfo);

    /**
     * 批量删除合同产品及送货信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteContractMaterialInfoByIds(String ids);

    /**
     * 删除合同产品及送货信息信息
     * 
     * @param contractMaterialInfoId 合同产品及送货信息ID
     * @return 结果
     */
    public int deleteContractMaterialInfoById(Long contractMaterialInfoId);

	public void batchUpdateContractMaterialInfoByParentId(Long customerInfoId, String parentId);
}
