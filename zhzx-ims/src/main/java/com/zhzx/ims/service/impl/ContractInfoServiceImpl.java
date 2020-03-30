package com.zhzx.ims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhzx.ims.mapper.ContractInfoMapper;
import com.zhzx.ims.domain.ContractInfo;
import com.zhzx.ims.service.IContractInfoService;
import com.zhzx.common.core.text.Convert;

/**
 * 合同信息Service业务层处理
 * 
 * @author kiver
 * @date 2019-12-04
 */
@Service
public class ContractInfoServiceImpl implements IContractInfoService 
{
    @Autowired
    private ContractInfoMapper contractInfoMapper;

    /**
     * 查询合同信息
     * 
     * @param contractInfoId 合同信息ID
     * @return 合同信息
     */
    @Override
    public ContractInfo selectContractInfoById(Long contractInfoId)
    {
        return contractInfoMapper.selectContractInfoById(contractInfoId);
    }

    /**
     * 查询合同信息列表
     * 
     * @param contractInfo 合同信息
     * @return 合同信息
     */
    @Override
    public List<ContractInfo> selectContractInfoList(ContractInfo contractInfo)
    {
        return contractInfoMapper.selectContractInfoList(contractInfo);
    }

    /**
     * 新增合同信息
     * 
     * @param contractInfo 合同信息
     * @return 结果
     */
    @Override
    public int insertContractInfo(ContractInfo contractInfo)
    {
        return contractInfoMapper.insertContractInfo(contractInfo);
    }

    /**
     * 修改合同信息
     * 
     * @param contractInfo 合同信息
     * @return 结果
     */
    @Override
    public int updateContractInfo(ContractInfo contractInfo)
    {
        return contractInfoMapper.updateContractInfo(contractInfo);
    }

    /**
     * 删除合同信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteContractInfoByIds(String ids)
    {
        return contractInfoMapper.deleteContractInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同信息信息
     * 
     * @param contractInfoId 合同信息ID
     * @return 结果
     */
    @Override
    public int deleteContractInfoById(Long contractInfoId)
    {
        return contractInfoMapper.deleteContractInfoById(contractInfoId);
    }

    /**
     * 第一次保存主表时更新子表parentID
     */
	@Override
	public void batchUpdateContractInfoByParentId(Long customerInfoId, String parentId) {
		ContractInfo contractInfo = new ContractInfo();
		contractInfo.setParentId(parentId);
		List<ContractInfo> list = contractInfoMapper.selectContractInfoList(contractInfo);
		for (ContractInfo contractInfo2 : list) {
			contractInfo2.setParentId(customerInfoId+"");
			contractInfoMapper.updateContractInfo(contractInfo2);
		}
	}

	@Override
	public List<ContractInfo> selectContractInfoCustomerList(ContractInfo contractInfo) {
		// TODO Auto-generated method stub
		return contractInfoMapper.selectContractInfoCustomerList(contractInfo);
	}
}
