package com.zhzx.ims.service;

import com.zhzx.ims.domain.CustomerInfo;
import java.util.List;

/**
 * 客户信息Service接口
 * 
 * @author kiver
 * @date 2019-12-04
 */
public interface ICustomerInfoService 
{
    /**
     * 查询客户信息
     * 
     * @param customerInfoId 客户信息ID
     * @return 客户信息
     */
    public CustomerInfo selectCustomerInfoById(Long customerInfoId);

    /**
     * 查询客户信息列表
     * 
     * @param customerInfo 客户信息
     * @return 客户信息集合
     */
    public List<CustomerInfo> selectCustomerInfoList(CustomerInfo customerInfo);

    /**
     * 新增客户信息
     * 
     * @param customerInfo 客户信息
     * @return 结果
     */
    public int insertCustomerInfo(CustomerInfo customerInfo);

    /**
     * 修改客户信息
     * 
     * @param customerInfo 客户信息
     * @return 结果
     */
    public int updateCustomerInfo(CustomerInfo customerInfo);

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCustomerInfoByIds(String ids);

    /**
     * 删除客户信息信息
     * 
     * @param customerInfoId 客户信息ID
     * @return 结果
     */
    public int deleteCustomerInfoById(Long customerInfoId);
}
