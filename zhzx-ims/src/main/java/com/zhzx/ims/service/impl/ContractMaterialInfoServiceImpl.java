package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.ContractMaterialInfoMapper;
import com.zhzx.ims.domain.ContractMaterialInfo;
import com.zhzx.ims.service.IContractMaterialInfoService;
import com.zhzx.common.core.text.Convert;

/**
 * 合同产品及送货信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Service
public class ContractMaterialInfoServiceImpl implements IContractMaterialInfoService 
{
    @Autowired
    private ContractMaterialInfoMapper contractMaterialInfoMapper;

    /**
     * 查询合同产品及送货信息
     * 
     * @param contractMaterialInfoId 合同产品及送货信息ID
     * @return 合同产品及送货信息
     */
    @Override
    public ContractMaterialInfo selectContractMaterialInfoById(Long contractMaterialInfoId)
    {
        return contractMaterialInfoMapper.selectContractMaterialInfoById(contractMaterialInfoId);
    }

    /**
     * 查询合同产品及送货信息列表
     * 
     * @param contractMaterialInfo 合同产品及送货信息
     * @return 合同产品及送货信息
     */
    @Override
    public List<ContractMaterialInfo> selectContractMaterialInfoList(ContractMaterialInfo contractMaterialInfo)
    {
        return contractMaterialInfoMapper.selectContractMaterialInfoList(contractMaterialInfo);
    }

    /**
     * 新增合同产品及送货信息
     * 
     * @param contractMaterialInfo 合同产品及送货信息
     * @return 结果
     */
    @Override
    public int insertContractMaterialInfo(ContractMaterialInfo contractMaterialInfo)
    {
        return contractMaterialInfoMapper.insertContractMaterialInfo(contractMaterialInfo);
    }

    /**
     * 修改合同产品及送货信息
     * 
     * @param contractMaterialInfo 合同产品及送货信息
     * @return 结果
     */
    @Override
    public int updateContractMaterialInfo(ContractMaterialInfo contractMaterialInfo)
    {
        return contractMaterialInfoMapper.updateContractMaterialInfo(contractMaterialInfo);
    }

    /**
     * 删除合同产品及送货信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteContractMaterialInfoByIds(String ids)
    {
        return contractMaterialInfoMapper.deleteContractMaterialInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同产品及送货信息信息
     * 
     * @param contractMaterialInfoId 合同产品及送货信息ID
     * @return 结果
     */
    @Override
    public int deleteContractMaterialInfoById(Long contractMaterialInfoId)
    {
        return contractMaterialInfoMapper.deleteContractMaterialInfoById(contractMaterialInfoId);
    }

	@Override
	public void batchUpdateContractMaterialInfoByParentId(Long customerInfoId, String parentId) {
		ContractMaterialInfo contractMaterialInfo = new ContractMaterialInfo();
		contractMaterialInfo.setParentId(parentId);
		List<ContractMaterialInfo> list = contractMaterialInfoMapper.selectContractMaterialInfoList(contractMaterialInfo);
		for (ContractMaterialInfo contractMaterialInfo2 : list) {
			contractMaterialInfo2.setParentId(customerInfoId+"");
			contractMaterialInfoMapper.updateContractMaterialInfo(contractMaterialInfo2);
		}
	}
}
