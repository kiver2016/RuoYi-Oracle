package com.zhzx.ims.mapper;

import com.zhzx.ims.domain.ContractInfo;
import java.util.List;

/**
 * 合同信息Mapper接口
 * 
 * @author kiver
 * @date 2019-12-04
 */
public interface ContractInfoMapper 
{
    /**
     * 查询合同信息
     * 
     * @param contractInfoId 合同信息ID
     * @return 合同信息
     */
    public ContractInfo selectContractInfoById(Long contractInfoId);

    /**
     * 查询合同信息列表
     * 
     * @param contractInfo 合同信息
     * @return 合同信息集合
     */
    public List<ContractInfo> selectContractInfoList(ContractInfo contractInfo);

    /**
     * 新增合同信息
     * 
     * @param contractInfo 合同信息
     * @return 结果
     */
    public int insertContractInfo(ContractInfo contractInfo);

    /**
     * 修改合同信息
     * 
     * @param contractInfo 合同信息
     * @return 结果
     */
    public int updateContractInfo(ContractInfo contractInfo);

    /**
     * 删除合同信息
     * 
     * @param contractInfoId 合同信息ID
     * @return 结果
     */
    public int deleteContractInfoById(Long contractInfoId);

    /**
     * 批量删除合同信息
     * 
     * @param contractInfoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteContractInfoByIds(String[] contractInfoIds);

	public List<ContractInfo> selectContractInfoCustomerList(ContractInfo contractInfo);
}
